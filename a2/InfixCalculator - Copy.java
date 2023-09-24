package cs445.a2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * This class uses two stacks to evaluate an infix arithmetic expression from an
 * InputStream. It should not create a full postfix expression along the way; it
 * should convert and evaluate in a pipelined fashion, in a single pass.
 */
public class InfixCalculator {
    // Tokenizer to break up our input into tokens
    StreamTokenizer tokenizer;

    // Stacks for operators (for converting to postfix) and operands (for
    // evaluating)
    StackInterface<Character> operatorStack;
    StackInterface<Double> operandStack;
    StackInterface<Character> bracketStack;

    /**
     * Initializes the calculator to read an infix expression from an input
     * stream.
     * @param input the input stream from which to read the expression
     */
    public InfixCalculator(InputStream input) {
        // Initialize the tokenizer to read from the given InputStream
        tokenizer = new StreamTokenizer(new BufferedReader(
                        new InputStreamReader(input)));

        // StreamTokenizer likes to consider - and / to have special meaning.
        // Tell it that these are regular characters, so that they can be parsed
        // as operators
        tokenizer.ordinaryChar('-');
        tokenizer.ordinaryChar('/');

        // Allow the tokenizer to recognize end-of-line, which marks the end of
        // the expression
        tokenizer.eolIsSignificant(true);

        // Initialize the stacks
        operatorStack = new ArrayStack<Character>();
        operandStack = new ArrayStack<Double>();
        bracketStack = new ArrayStack<Character>();
    }

    /**
     * Parses and evaluates the expression read from the provided input stream,
     * then returns the resulting value
     * @return the value of the infix expression that was parsed
     */
    public Double evaluate() throws InvalidExpressionException {
        // Get the first token. If an IO exception occurs, replace it with a
        // runtime exception, causing an immediate crash.
        try {
            tokenizer.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int previousType = 0; // current type is either operand (1) or operator (2)
        int currentType = 0; // current type is either operand (1) or operator (2)
        // Continue processing tokens until we find end-of-line
        while (tokenizer.ttype != StreamTokenizer.TT_EOL) {

            // Consider possible token types
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                  currentType = 1; //Designates current token type is Operand
                    // If the token is a number, process it as a double-valued
                    // operand
                    if (currentType != previousType){
                      handleOperand((double)tokenizer.nval);
                      break;
                    }
                    else{
                      throw new InvalidExpressionException("Cannot have two operands in a row.");
                    }
                case '+':
                case '-':
                case '*':
                case '/':
                case '\\':
                case '^':
                    currentType = 2; //Designates the current token type is Operator
                    // If the token is any of the above characters, process it
                    // is an operator
                    if (currentType != previousType){
                      handleOperator((char)tokenizer.ttype);
                      break;
                    }
                    else{
                      throw new InvalidExpressionException("Cannot have two operators in a row.");
                    }
                case '(':
                case '<':
                    // If the token is open bracket, process it as such. Forms
                    // of bracket are interchangeable but must nest properly.
                    currentType = 2;
                    if (previousType != 1){
                      handleOpenBracket((char)tokenizer.ttype);
                      break;
                    }
                    else{
                      handleOperator('*');
                      handleOpenBracket((char)tokenizer.ttype);
                      break;
                    }
                case ')':
                case '>':
                    // If the token is close bracket, process it as such. Forms
                    // of bracket are interchangeable but must nest properly.
                    if (previousType != 2){
                      handleCloseBracket((char)tokenizer.ttype);
                      break;
                    }
                    else{
                      throw new InvalidExpressionException("Cannot have operator directly before close parenthesis.");
                    }
                case StreamTokenizer.TT_WORD:
                    // If the token is a "word", throw an expression error
                    throw new InvalidExpressionException("Unrecognized symbol: " +
                                    tokenizer.sval);
                default:
                    // If the token is any other type or value, throw an
                    // expression error
                    throw new InvalidExpressionException("Unrecognized symbol: " +
                                    String.valueOf((char)tokenizer.ttype));
            }

            // Read the next token, again converting any potential IO exception
            try {
                previousType = currentType;
                tokenizer.nextToken();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Almost done now, but we may have to process remaining operators in
        // the operators stack
        double result = handleRemainingOperators();

        // Return the result of the evaluation
        return result;
    }

    /**
     * This method is called when the calculator encounters an operand. It
     * manipulates operatorStack and/or operandStack to process the operand
     * according to the Infix-to-Postfix and Postfix-evaluation algorithms.
     * @param operand the operand token that was encountered
     */
    void handleOperand(double operand) {
        operandStack.push(operand);
    }

    /**
     * This method is called when the calculator encounters an operator. It
     * manipulates operatorStack and/or operandStack to process the operator
     * according to the Infix-to-Postfix and Postfix-evaluation algorithms.
     * @param operator the operator token that was encountered
     */
    void handleOperator(char operator) {
        if (operatorStack.isEmpty()){
          operatorStack.push(operator); // if the stack is empty, YES PUSH
        }
        else{
          int precedenceLevelOperator = 0; // sets default precedence level to 0 for troubleshooting
          int precedenceLevelStack = 0; //see above
          switch (operator){ // checks the operator type and assigns precedence level accordingly
            case '^':
              precedenceLevelOperator = 3;//highest precedence
              break;
            case '*':
            case '/':
            case '\\':
              precedenceLevelOperator = 2;//mid precedence
              break;
            case '+':
            case '-':
              precedenceLevelOperator = 1;//lowest precedence
              break;
            }

            switch (operatorStack.peek()){//does same as above for what's on the stack
              case '^':
                precedenceLevelStack = 3;
                break;
              case '*':
              case '/':
              case '\\':
                precedenceLevelStack = 2;
                break;
              case '+':
              case '-':
                precedenceLevelStack = 1;
                break;
              }

          if (precedenceLevelOperator > precedenceLevelStack){//if stack is of lower precedence
            operatorStack.push(operator);//push! yay!
          }
          else{//if stack is of same or higher precedence
            char stackOp;
            double stackNum1;
            double stackNum2;
            if (!operatorStack.isEmpty()){
              stackOp = operatorStack.pop();
            }else{
              throw new InvalidExpressionException("No valid operator present.");
            }
            if (!operandStack.isEmpty()){
              stackNum2 = operandStack.pop();
            }else{
              throw new InvalidExpressionException("Not enough operands to calculate.");
            }
            if (!operandStack.isEmpty()){
              stackNum1 = operandStack.pop();
            }else{
              throw new InvalidExpressionException("Not enough operands to calculate.");
            }
            double result;
            switch(stackOp){//check for what the stack operator is and calculate accordingly
              case '(':
              case '<':
                operatorStack.push(stackOp);
                break;
              case ')':
              case '>':
                handleCloseBracket(operator);
                break;
              case '^':
                result = Math.pow(stackNum1, stackNum2);
                operandStack.push(result);//push result back on to operands
                handleOperator(operator);//recall same function with operator and NEW operator stack
                break;
              case '*':
                result = stackNum1 * stackNum2;
                operandStack.push(result);
                handleOperator(operator);
                break;
              case '/':
              if (stackNum2 != 0){
                result = stackNum1 / stackNum2;
                operandStack.push(result);
                handleOperator(operator);
                break;
              }
              else{
                throw new InvalidExpressionException("Cannot divide by zero.");
              }
              case '\\':
              if (stackNum2 != 0){
                result = Math.floor(stackNum1 / stackNum2);
                operandStack.push(result);
                handleOperator(operator);
                break;
              }
              else{
                throw new InvalidExpressionException("Cannot divide by zero.");
              }
              case '+':
                result = stackNum1 + stackNum2;
                operandStack.push(result);
                handleOperator(operator);
                break;
              case '-':
                result = stackNum1 - stackNum2;
                operandStack.push(result);
                handleOperator(operator);
                break;
            }
          }

          }
        }


    /**
     * This method is called when the calculator encounters an open bracket. It
     * manipulates operatorStack and/or operandStack to process the open bracket
     * according to the Infix-to-Postfix and Postfix-evaluation algorithms.
     * @param openBracket the open bracket token that was encountered
     */
    void handleOpenBracket(char openBracket) {
        // TODO: Complete this method
        operatorStack.push(openBracket);
        switch(openBracket){
          case'(':
            bracketStack.push(')');
            break;
          case'<':
            bracketStack.push('>');
            break;
        }
    }

    /**
     * This method is called when the calculator encounters a close bracket. It
     * manipulates operatorStack and/or operandStack to process the close
     * bracket according to the Infix-to-Postfix and Postfix-evaluation
     * algorithms.
     * @param closeBracket the close bracket token that was encountered
     */
    void handleCloseBracket(char closeBracket) {
        // TODO: Complete this method
        if (bracketStack.isEmpty()){
          throw new InvalidExpressionException("No corresponding open bracket found to close bracket.");
        }else if (!bracketStack.pop().equals(closeBracket)){
          throw new InvalidExpressionException("Open and Close brackets do not match.");
        }else{
          char currentOp;
          if (!operatorStack.isEmpty()){
            currentOp = operatorStack.pop();
          }else{
            throw new InvalidExpressionException("No valid operator present.");
          }
          double result = 0;
          while (currentOp != '(' && currentOp != '<'){ // while we don't have an open bracket
          double stackNum1;
          double stackNum2;
          if (!operandStack.isEmpty()){
            stackNum2 = operandStack.pop();
          }else{
            throw new InvalidExpressionException("Not enough operands to calculate.");
          }
          if (!operandStack.isEmpty()){
            stackNum1 = operandStack.pop();
          }else{
            throw new InvalidExpressionException("Not enough operands to calculate.");
          }
            switch (currentOp){
              case '^':
                result = Math.pow(stackNum1, stackNum2);
                break;
              case '*':
                result = stackNum1 * stackNum2;
                break;
              case '/':
              if (stackNum2 != 0){
                result = stackNum1 / stackNum2;
                break;
              }
              else{
                throw new InvalidExpressionException("Cannot divide by zero.");
              }
              case '\\':
              if (stackNum2 != 0){
                result = Math.floor(stackNum1 / stackNum2);
                break;
              }
              else{
                throw new InvalidExpressionException("Cannot divide by zero.");
              }
              case '+':
                result = stackNum1 + stackNum2;
                break;
              case '-':
                result = stackNum1 - stackNum2;
                break;
            }//end switch
            operandStack.push(result);
            currentOp = operatorStack.pop();
          }//end while
        }
    }

    /**
     * This method is called when the calculator encounters the end of an
     * expression. It manipulates operatorStack and/or operandStack to process
     * the operators that remain on the stack, according to the Infix-to-Postfix
     * and Postfix-evaluation algorithms.
     */
    double handleRemainingOperators() {
        // TODO: Complete this method
        if (bracketStack.isEmpty()){
        double result = 0;
        while (!operandStack.isEmpty() && !operatorStack.isEmpty()){
          char stackOperator;
          double stackNum1;
          double stackNum2;
          if (!operatorStack.isEmpty()){
            stackOperator = operatorStack.pop();
          }else{
            throw new InvalidExpressionException("No valid operator present.");
          }
          if (!operandStack.isEmpty()){
            stackNum2 = operandStack.pop();
          }else{
            throw new InvalidExpressionException("Not enough operands to calculate.");
          }
          if (!operandStack.isEmpty()){
            stackNum1 = operandStack.pop();
          }else{
            throw new InvalidExpressionException("Not enough operands to calculate.");
          }
          switch(stackOperator){//check for what the stack operator is and calculate accordingly
            case '^':
              result = Math.pow(stackNum1, stackNum2);
              break;
            case '*':
              result = stackNum1 * stackNum2;
              break;
            case '/':
            if (stackNum2 != 0){
              result = stackNum1 / stackNum2;
              break;
            }
            else{
              throw new InvalidExpressionException("Cannot divide by zero.");
            }
            case '\\':
            if (stackNum2 != 0){
              result = Math.floor(stackNum1 / stackNum2);
              break;
            }
            else{
              throw new InvalidExpressionException("Cannot divide by zero.");
            }
            case '+':
              result = stackNum1 + stackNum2;
              break;
            case '-':
              result = stackNum1 - stackNum2;
              break;
          }

          if (!operandStack.isEmpty()){
            operandStack.push(result);
          }
        }
        return result;
      }
      else{
        throw new InvalidExpressionException("Open bracket does not have corresponding close bracket.");
      }
    }


    /**
     * Creates an InfixCalculator object to read from System.in, then evaluates
     * its input and prints the result.
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.println("Infix expression:");
        InfixCalculator calculator = new InfixCalculator(System.in);
        Double value = null;
        try {
            value = calculator.evaluate();
        } catch (InvalidExpressionException e) {
            System.out.println("Invalid expression: " + e.getMessage());
        }
        if (value != null) {
            System.out.println(value);
        }
    }

}

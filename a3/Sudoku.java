package cs445.a3;

import java.util.List;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sudoku {
    private static int[][] initialBoard = new int[9][9];
    private static int counter = 0;

    static boolean isFullSolution(int[][] board) {
      for (int row = 0; row < 9; row++){
        for (int col = 0; col < 9; col++){
          // BEGIN ROW CHECK
            for (int j = 0; j < 9; j++){
              if (board[row][col] == 0){
                return false;
              }
              else if (col == j){}//end ELSE IF
              else if (board[row][col] == board[row][j]){
                // if the value is NOT a 0 and it equals another value, return null
                return false;
              }//end ELSE IF
            }//end FOR j

          // BEGIN COL CHECK
          for (int i = 0; i < 9; i++){

            if (board[row][col] == 0){
              return false;
            }
            else if (row == i){}
            else if (board[row][col] == board[i][col]){
              // if the value is NOT a 0 and it equals another value, return null
              return false;
            }//end ELSE IF
          }//end FOR i

          // BEGIN LITTLE BOX CHECK
          switch (row){
            case (0): case (1): case (2):
              switch (col){
                case (0): case (1): case (2):
                  for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end ELSE IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
                case (3): case (4): case (5):
                  for (int i = 0; i < 3; i++){
                    for (int j = 3; j < 6; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
                case (6): case (7): case (8):
                  for (int i = 0; i < 3; i++){
                    for (int j = 6; j < 9; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
              }//end SWITCH col
              break;
            case (3): case (4): case (5):
              switch (col){
                case (0): case (1): case (2):
                  for (int i = 3; i < 6; i++){
                    for (int j = 0; j < 3; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
                case (3): case (4): case (5):
                  for (int i = 3; i < 6; i++){
                    for (int j = 3; j < 6; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
                case (6): case (7): case (8):
                  for (int i = 3; i < 6; i++){
                    for (int j = 6; j < 9; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
              }//end SWITCH col
              break;
            case (6): case (7): case (8):
              switch (col){
                case (0): case (1): case (2):
                  for (int i = 6; i < 9; i++){
                    for (int j = 0; j < 3; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
                case (3): case (4): case (5):
                  for (int i = 6; i < 9; i++){
                    for (int j = 3; j < 6; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
                case (6): case (7): case (8):
                  for (int i = 6; i < 9; i++){
                    for (int j = 6; j < 9; j++){
                      if (board[row][col] == 0){return false;}
                      else if (row == i && col == j){}//end IF
                      else if (board[row][col] == board[i][j]){return false;}//end ELSE IF
                  } }//end FOR j//end FOR i
                  break;
              }//end SWITCH col
              break;
            } //end SWITCH row
        }//end FOR col
      }//end FOR row

    return true;


        // TODO: Complete this method
        /*
        for (int row = 0; row < 9; row++){
          for (int col = 0; col < 9; col++){

            if (row < 3 && col < 3){


              for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 1-1 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 6 && col < 3){


              for (int i = 3; i < 6; i++){
                for (int j = 0; j < 3; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 2-1 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 9 && col < 3){


              for (int i = 6; i < 9; i++){
                for (int j = 0; j < 3; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 3-1 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}




            } else if (row < 3 && col < 6){


              for (int i = 0; i < 3; i++){
                for (int j = 3; j < 6; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 1-2 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 6 && col < 6){


              for (int i = 3; i < 6; i++){
                for (int j = 3; j < 6; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 2-2 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 9 && col < 6){


              for (int i = 6; i < 9; i++){
                for (int j = 3; j < 6; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 3-2 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 3 && col < 9){


              for (int i = 0; i < 3; i++){
                for (int j = 6; j < 9; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 1-3 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 6 && col < 9){


              for (int i = 3; i < 6; i++){
                for (int j = 6; j < 9; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 2-3 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 9 && col < 9){


              for (int i = 6; i < 9; i++){
                for (int j = 6; j < 9; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 3-3 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else {
              //System.out.println("Done with box check.");
            }
          }
        }

        // Run through every column to see if it's valid
        for (int col = 0; col < 9; col++){
          for (int row = 0; row < 9; row++){
            for (int i = row + 1; i < 9; i++){
              if (board[row][col] == board[i][col]){
                // IF THIS IS TRUE, NOT A FULL SOLUTION! RETURN FALSE!
                System.out.println("Failed in col check.");
                return false;
              }
            }
          }
        }

        for (int row = 0; row < 9; row++){
          for (int col = 0; col < 9; col++){
            for (int i = col + 1; i < 9; i++){
              if (board[row][col] == board[row][i]){
                // IF THIS IS TRUE, NOT A FULL SOLUTION! RETURN FALSE!
                System.out.println("Failed in row check");
                return false;
              }
            }
          }
        }
        return true;*/
    }

    static boolean reject(int[][] board) {
        // TODO: Complete this method

        for (int row = 0; row < 9; row++){
          for (int col = 0; col < 9; col++){
            // BEGIN ROW CHECK
              for (int j = 0; j < 9; j++){
                if (col == j){
                  //Do nothing in this case, the same number is alright
                }//end IF
                else if (board[row][col] != 0 && board[row][col] == board[row][j]){
                  // if the value is NOT a 0 and it equals another value, return null
                  return true;
                }//end ELSE IF
              }//end FOR j

            // BEGIN COL CHECK
            for (int i = 0; i < 9; i++){

              if (row == i){
                //Do nothing in this case, the same number is alright
              }
              else if (board[row][col] != 0 && board[row][col] == board[i][col]){
                // if the value is NOT a 0 and it equals another value, return null
                return true;
              }//end ELSE IF
            }//end FOR i

            // BEGIN LITTLE BOX CHECK
            switch (row){
              case (0): case (1): case (2):
                switch (col){
                  case (0): case (1): case (2):
                    for (int i = 0; i < 3; i++){
                      for (int j = 0; j < 3; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                  case (3): case (4): case (5):
                    for (int i = 0; i < 3; i++){
                      for (int j = 3; j < 6; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                  case (6): case (7): case (8):
                    for (int i = 0; i < 3; i++){
                      for (int j = 6; j < 9; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                }//end SWITCH col
                break;
              case (3): case (4): case (5):
                switch (col){
                  case (0): case (1): case (2):
                    for (int i = 3; i < 6; i++){
                      for (int j = 0; j < 3; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                  case (3): case (4): case (5):
                    for (int i = 3; i < 6; i++){
                      for (int j = 3; j < 6; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                  case (6): case (7): case (8):
                    for (int i = 3; i < 6; i++){
                      for (int j = 6; j < 9; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                }//end SWITCH col
                break;
              case (6): case (7): case (8):
                switch (col){
                  case (0): case (1): case (2):
                    for (int i = 6; i < 9; i++){
                      for (int j = 0; j < 3; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                  case (3): case (4): case (5):
                    for (int i = 6; i < 9; i++){
                      for (int j = 3; j < 6; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                  case (6): case (7): case (8):
                    for (int i = 6; i < 9; i++){
                      for (int j = 6; j < 9; j++){
                        if (row == i && col == j){}//end IF
                        else if (board[row][col] != 0 && board[row][col] == board[i][j]){return true;}//end ELSE IF
                    } }//end FOR j//end FOR i
                    break;
                }//end SWITCH col
                break;
              } //end SWITCH row
          }//end FOR col
        }//end FOR row
/*
        for (int row = 0; row < 9; row++){
          for (int col = 0; col < 9; col++){

            if (row < 3 && col < 3){


              for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 1-1 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 6 && col < 3){


              for (int i = 3; i < 6; i++){
                for (int j = 0; j < 3; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 2-1 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 9 && col < 3){


              for (int i = 6; i < 9; i++){
                for (int j = 0; j < 3; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 3-1 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}




            } else if (row < 3 && col < 6){


              for (int i = 0; i < 3; i++){
                for (int j = 3; j < 6; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 1-2 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 6 && col < 6){


              for (int i = 3; i < 6; i++){
                for (int j = 3; j < 6; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 2-2 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 9 && col < 6){


              for (int i = 6; i < 9; i++){
                for (int j = 3; j < 6; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 3-2 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 3 && col < 9){


              for (int i = 0; i < 3; i++){
                for (int j = 6; j < 9; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 1-3 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 6 && col < 9){


              for (int i = 3; i < 6; i++){
                for (int j = 6; j < 9; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 2-3 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else if (row < 9 && col < 9){


              for (int i = 6; i < 9; i++){
                for (int j = 6; j < 9; j++){
                  if (board[row][col] != board[i][j]){
                    // We're all good!
                  } else if (row == i && col == j){
                    // We're comparing the same value to itself!
                  } else {
                    System.out.println("Failed in 3-3 little box!");
                    System.out.println("The error occurred as follows:\n");
                    System.out.println("Original:");
                    System.out.println("Row:  " + row + "     Col:  " + col);
                    System.out.println("Second Occurence:");
                    System.out.println("i:    " + i + "     j:    " + j);
                    return false;
              }}}



            } else {
              //System.out.println("Done with box check.");
            }
      /*
            switch (row){
              case (0):
              case (1):
              case (2):
                switch (col){
                  case (0):
                  case (1):
                  case (2):
                    for (int i = row; i < 3; i++){
                      for (int j = col; j < 3; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                  case (3):
                  case (4):
                  case (5):
                    for (int i = row; i < 6; i++){
                      for (int j = col; j < 6; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                  case (6):
                  case (7):
                  case (8):
                    for (int i = row; i < 9; i++){
                      for (int j = col; j < 9; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                }
              case (3):
              case (4):
              case (5):
                switch (col){
                  case (0):
                  case (1):
                  case (2):
                    for (int i = row; i < 3; i++){
                      for (int j = col; j < 3; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                  case (3):
                  case (4):
                  case (5):
                    for (int i = row; i < 6; i++){
                      for (int j = col; j < 6; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                  case (6):
                  case (7):
                  case (8):
                    for (int i = row; i < 9; i++){
                      for (int j = col; j < 9; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                }
              case (6):
              case (7):
              case (8):
                switch (col){
                  case (0):
                  case (1):
                  case (2):
                    for (int i = row; i < 3; i++){
                      for (int j = col; j < 3; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                  case (3):
                  case (4):
                  case (5):
                    for (int i = row; i < 6; i++){
                      for (int j = col; j < 6; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                  case (6):
                  case (7):
                  case (8):
                    for (int i = row; i < 9; i++){
                      for (int j = col; j < 9; j++){
                        if (board[row][col] == board[i][j]){
                          return false;
                        }
                      }
                    }
                    break;
                }
            }
            */
          //}
      //  }
      return false;
    }//end REJECT

    static int[][] extend(int[][] board) {
        int[][] temp = new int[9][9]; // Creates new object for extend!
        boolean extended = false;
        for (int i = 0; i < 9; i++){
          for (int j = 0; j < 9; j++){
            if (board[i][j] != 0){
              temp[i][j] = board[i][j]; // copies value in board over to temp
            } else if (board[i][j] == 0 && extended == false) {
              temp[i][j] = 1;
              extended = true;
            } else{
              // Do nothing, let the loop finish it's course
            }//end ELSE
          }//end FOR j
        }//end FOR i
        if (extended == true){
          return temp;
        }
        else{
          return null; //Returns null if all the spots in board[][] are filled, aka we can't extend anymore
        }
    }

    static int[][] next(int[][] board) {
        // TODO: Complete this method

        // MAKE SURE TO COMPARE TO INITIAL BOARD!!! DON'T WANT TO CHANGE A GIVEN VALUE

        for (int i = 8; i >= 0; i--){
          for (int j = 8; j >= 0; j--){

            if (board[i][j] != 0 && initialBoard[i][j] == 0){
              // Valid point to change!
              if (board[i][j] != 9){
                board[i][j]++; // increment by one
                return board;
              }//end IF board=9
              return null;

            }//end IF board !=0 and iBoard=0
          }//end FOR j
        }//end FOR i
        return null;
    }

    static void testIsFullSolution() {
        // TODO: Complete this method

        System.out.println("----------------------------------------------------------");
        System.out.println("--------------- Begin testIsFullSolution() ---------------");
        System.out.println("----------------------------------------------------------\n\n");

        System.out.println("This test will ensure that isFullSolution() is able to handle all\n"+
                            "the corner cases that it will find. It tests every little box that\n"+
                            "the game would check for, it tests the rows failing, and the columns\n"+
                            "failing as well. Then, it has some correct boards in as well to verify\n"+
                            "that it isn't just throwing false at every board, as well as a 0 value.\n");

        int Anotherboard[][] = new int[][] {
          {7, 3, 5, 6, 1, 4, 8, 9, 2},
          {8, 4, 2, 9, 7, 3, 5, 6, 1},
          {9, 6, 1, 2, 8, 5, 3, 7, 4},
          {2, 8, 6, 3, 4, 9, 1, 5, 7},
          {4, 1, 3, 8, 5, 7, 9, 2, 6},
          {5, 7, 9, 1, 2, 6, 4, 3, 8},
          {1, 5, 7, 4, 9, 2, 6, 8, 3},
          {6, 9, 4, 7, 3, 8, 2, 1, 5},
          {3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(Anotherboard);
        boolean flag = isFullSolution(Anotherboard);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

//////////////////////////////////////////////////////////////////////////////
// Try row = 0 col = 1 errors
        int Anotherboard11[][] = new int[][] {
      //j= 0  1  2  3  4  5  6  7  8
/*i = 0 */{7, 3, 5, 6, 1, 4, 8, 9, 2},
   /* 1 */{8, 4, 2, 9, 7, 3, 5, 6, 1},
   /* 2 */{9, 6, 3, 2, 8, 5, 3, 7, 4},
   /* 3 */{2, 8, 6, 3, 4, 9, 1, 5, 7},
   /* 4 */{4, 1, 3, 8, 5, 7, 9, 2, 6},
   /* 5 */{5, 7, 9, 1, 2, 6, 4, 3, 8},
   /* 6 */{1, 5, 7, 4, 9, 2, 6, 8, 3},
   /* 7 */{6, 9, 4, 7, 3, 8, 2, 1, 5},
   /* 8 */{3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(Anotherboard11);
        flag = isFullSolution(Anotherboard11);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");
        //////////////////////////////////////////////////////////////////////////////
        // Try row = 0 col = 1 errors
                int Anotherboard12[][] = new int[][] {
              //j= 0  1  2  3  4  5  6  7  8
        /*i = 0 */{7, 3, 5, 6, 6, 4, 8, 9, 2},
           /* 1 */{8, 4, 2, 9, 7, 3, 5, 6, 1},
           /* 2 */{9, 6, 1, 2, 8, 5, 3, 7, 4},
           /* 3 */{2, 8, 6, 3, 4, 9, 1, 5, 7},
           /* 4 */{4, 1, 3, 8, 5, 7, 9, 2, 6},
           /* 5 */{5, 7, 9, 1, 2, 6, 4, 3, 8},
           /* 6 */{1, 5, 7, 4, 9, 2, 6, 8, 3},
           /* 7 */{6, 9, 4, 7, 3, 8, 2, 1, 5},
           /* 8 */{3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(Anotherboard12);
        flag = isFullSolution(Anotherboard12);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");
        //////////////////////////////////////////////////////////////////////////////
        // Try row = 0 col = 1 errors
        int Anotherboard13[][] = new int[][] {
        //j= 0  1  2  3  4  5  6  7  8
    /*i = 0 */{7, 3, 5, 6, 1, 4, 8, 9, 2},
       /* 1 */{8, 4, 2, 9, 7, 3, 5, 6, 1},
       /* 2 */{9, 6, 1, 2, 8, 5, 3, 1, 4},
       /* 3 */{2, 8, 6, 3, 4, 9, 1, 5, 7},
       /* 4 */{4, 1, 3, 8, 5, 7, 9, 2, 6},
       /* 5 */{5, 7, 9, 1, 2, 6, 4, 3, 8},
       /* 6 */{1, 5, 7, 4, 9, 2, 6, 8, 3},
       /* 7 */{6, 9, 4, 7, 3, 8, 2, 1, 5},
       /* 8 */{3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(Anotherboard13);
        flag = isFullSolution(Anotherboard13);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");
        //////////////////////////////////////////////////////////////////////////////
          // Try row = 0 col = 1 errors
        int Anotherboard21[][] = new int[][] {
        //j= 0  1  2  3  4  5  6  7  8
    /*i = 0 */{7, 3, 5, 6, 1, 4, 8, 9, 2},
       /* 1 */{8, 4, 2, 9, 7, 3, 5, 6, 1},
       /* 2 */{9, 6, 1, 2, 8, 5, 3, 7, 4},
       /* 3 */{2, 8, 6, 3, 4, 9, 1, 5, 7},
       /* 4 */{4, 1, 3, 8, 5, 7, 9, 2, 6},
       /* 5 */{5, 9, 9, 1, 2, 6, 4, 3, 8},
       /* 6 */{1, 5, 7, 4, 9, 2, 6, 8, 3},
       /* 7 */{6, 9, 4, 7, 3, 8, 2, 1, 5},
       /* 8 */{3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(Anotherboard21);
        flag = isFullSolution(Anotherboard21);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");
        int Anotherboard22[][] = new int[][] {
            {7, 3, 5, 6, 1, 4, 8, 9, 2},
            {8, 4, 2, 9, 7, 3, 5, 6, 1},
            {9, 6, 1, 2, 8, 5, 3, 7, 4},
            {2, 8, 6, 3, 4, 9, 1, 5, 7},
            {4, 1, 3, 8, 5, 7, 9, 2, 6},
            {5, 7, 9, 4, 2, 6, 4, 3, 8},
            {1, 5, 7, 4, 9, 2, 6, 8, 3},
            {6, 9, 4, 7, 3, 8, 2, 1, 5},
            {3, 2, 8, 5, 6, 1, 7, 4, 9}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(Anotherboard22);
        flag = isFullSolution(Anotherboard22);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int Anotherboard23[][] = new int[][] {
            {7, 3, 5, 6, 1, 4, 8, 9, 2},
            {8, 4, 2, 9, 7, 3, 5, 6, 1},
            {9, 6, 1, 2, 8, 5, 3, 7, 4},
            {2, 8, 6, 3, 4, 9, 1, 5, 7},
            {4, 1, 3, 8, 5, 7, 9, 2, 9},
            {5, 7, 9, 1, 2, 6, 4, 3, 8},
            {1, 5, 7, 4, 9, 2, 6, 8, 3},
            {6, 9, 4, 7, 3, 8, 2, 1, 5},
            {3, 2, 8, 5, 6, 1, 7, 4, 9}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(Anotherboard23);
          flag = isFullSolution(Anotherboard23);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int Anotherboard31[][] = new int[][] {
            {7, 3, 5, 6, 1, 4, 8, 9, 2},
            {8, 4, 2, 9, 7, 3, 5, 6, 1},
            {9, 6, 1, 2, 8, 5, 3, 7, 4},
            {2, 8, 6, 3, 4, 9, 1, 5, 7},
            {4, 1, 3, 8, 5, 7, 9, 2, 6},
            {5, 7, 9, 1, 2, 6, 4, 3, 8},
            {1, 5, 7, 4, 9, 2, 6, 8, 3},
            {6, 9, 4, 7, 3, 8, 2, 1, 5},
            {3, 2, 3, 5, 6, 1, 7, 4, 9}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(Anotherboard31);
          flag = isFullSolution(Anotherboard31);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int Anotherboard32[][] = new int[][] {
            {7, 3, 5, 6, 1, 4, 8, 9, 2},
            {8, 4, 2, 9, 7, 3, 5, 6, 1},
            {9, 6, 1, 2, 8, 5, 3, 7, 4},
            {2, 8, 6, 3, 4, 9, 1, 5, 7},
            {4, 1, 3, 8, 5, 7, 9, 2, 6},
            {5, 7, 9, 1, 2, 6, 4, 3, 8},
            {1, 5, 7, 4, 9, 2, 6, 8, 3},
            {6, 9, 4, 7, 3, 8, 2, 1, 5},
            {3, 2, 8, 3, 6, 1, 7, 4, 9}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(Anotherboard32);
          flag = isFullSolution(Anotherboard32);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");


        int Anotherboard33[][] = new int[][] {
            {7, 3, 5, 6, 1, 4, 8, 9, 2},
            {8, 4, 2, 9, 7, 3, 5, 6, 1},
            {9, 6, 1, 2, 8, 5, 3, 7, 4},
            {2, 8, 6, 3, 4, 9, 1, 5, 7},
            {4, 1, 3, 8, 5, 7, 9, 2, 6},
            {5, 7, 9, 1, 2, 6, 4, 3, 8},
            {1, 5, 7, 4, 9, 2, 6, 8, 3},
            {6, 9, 4, 7, 3, 8, 2, 1, 5},
            {3, 2, 8, 5, 6, 1, 7, 4, 5}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(Anotherboard33);
          flag = isFullSolution(Anotherboard33);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");


        int AnotherboardWILD[][] = new int[][] {
            {7, 3, 5, 6, 1, 4, 8, 9, 7},
            {8, 7, 2, 9, 7, 3, 5, 7, 1},
            {9, 6, 7, 2, 8, 5, 7, 7, 4},
            {2, 8, 6, 7, 4, 7, 1, 5, 7},
            {4, 1, 3, 8, 7, 7, 9, 2, 6},
            {5, 7, 9, 7, 2, 7, 4, 3, 8},
            {1, 5, 7, 4, 9, 2, 7, 8, 3},
            {6, 7, 4, 7, 3, 8, 2, 7, 5},
            {7, 2, 8, 5, 6, 1, 7, 4, 7}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(AnotherboardWILD);
          flag = isFullSolution(AnotherboardWILD);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int AnotherboardRow[][] = new int[][] {
          {7, 3, 5, 6, 1, 4, 8, 9, 2},
          {8, 4, 2, 9, 7, 3, 5, 6, 1},
          {9, 6, 1, 2, 8, 5, 3, 7, 4},
          {2, 8, 6, 3, 4, 9, 1, 6, 7},
          {4, 1, 3, 8, 5, 7, 9, 2, 6},
          {5, 7, 9, 1, 2, 6, 4, 3, 8},
          {1, 5, 7, 4, 9, 2, 6, 8, 3},
          {6, 9, 4, 7, 3, 8, 2, 1, 5},
          {3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(AnotherboardRow);
        flag = isFullSolution(AnotherboardRow);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int AnotherboardCol[][] = new int[][] {
          {7, 3, 5, 6, 1, 4, 8, 9, 2},
          {8, 4, 2, 9, 7, 3, 5, 6, 1},
          {9, 6, 1, 2, 8, 5, 3, 7, 4},
          {2, 8, 6, 3, 4, 9, 1, 5, 7},
          {4, 1, 3, 8, 5, 7, 9, 2, 6},
          {5, 7, 9, 1, 2, 6, 4, 3, 8},
          {1, 5, 7, 4, 9, 2, 6, 8, 3},
          {6, 9, 4, 7, 3, 8, 2, 1, 5},
          {7, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(AnotherboardCol);
        flag = isFullSolution(AnotherboardCol);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int AnotherboardZero[][] = new int[][] {
          {7, 3, 5, 6, 1, 4, 8, 9, 2},
          {8, 4, 2, 9, 7, 3, 5, 6, 1},
          {9, 6, 1, 2, 8, 5, 3, 7, 4},
          {2, 8, 6, 3, 4, 9, 1, 5, 7},
          {4, 1, 3, 8, 0, 7, 9, 2, 6},
          {5, 7, 9, 1, 2, 6, 4, 3, 8},
          {1, 5, 7, 4, 9, 2, 6, 8, 3},
          {6, 9, 4, 7, 3, 8, 2, 1, 5},
          {3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(AnotherboardZero);
        flag = isFullSolution(AnotherboardZero);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int goodBoard1[][] = new int[][] {
            {4, 3, 5, 2, 6, 9, 7, 8, 1},
            {6, 8, 2, 5, 7, 1, 4, 9, 3},
            {1, 9, 7, 8, 3, 4, 5, 6, 2},
            {8, 2, 6, 1, 9, 5, 3, 4, 7},
            {3, 7, 4, 6, 8, 2, 9, 1, 5},
            {9, 5, 1, 7, 4, 3, 6, 2, 8},
            {5, 1, 9, 3, 2, 6, 8, 7, 4},
            {2, 4, 8, 9, 5, 7, 1, 3, 6},
            {7, 6, 3, 4, 1, 8, 2, 5, 9}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(goodBoard1);
          flag = isFullSolution(goodBoard1);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int goodBoard2[][] = new int[][] {
            {5, 8, 1, 6, 7, 2, 4, 3, 9},
            {7, 9, 2, 8, 4, 3, 6, 5, 1},
            {3, 6, 4, 5, 9, 1, 7, 8, 2},
            {4, 3, 8, 9, 5, 7, 2, 1, 6},
            {2, 5, 6, 1, 8, 4, 9, 7, 3},
            {1, 7, 9, 3, 2, 6, 8, 4, 5},
            {8, 4, 5, 2, 1, 9, 3, 6, 7},
            {9, 1, 3, 7, 6, 8, 5, 2, 4},
            {6, 2, 7, 4, 3, 5, 1, 9, 8}
          };

          System.out.println("\nInitial Board:\n");
          printBoard(goodBoard2);
          flag = isFullSolution(goodBoard2);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        int goodBoard3[][] = new int[][] {
            {7, 3, 6, 4, 5, 2, 9, 8, 1},
            {1, 9, 8, 6, 3, 7, 4, 5, 2},
            {4, 2, 5, 9, 8, 1, 3, 7, 6},
            {3, 6, 4, 5, 2, 8, 1, 9, 7},
            {9, 5, 2, 7, 1, 4, 6, 3, 8},
            {8, 1, 7, 3, 9, 6, 2, 4, 5},
            {2, 8, 9, 1, 7, 3, 5, 6, 4},
            {6, 7, 3, 2, 4, 5, 8, 1, 9},
            {5, 4, 1, 8, 6, 9, 7, 2, 3}
          };
          System.out.println("\nInitial Board:\n");
          printBoard(goodBoard3);
          flag = isFullSolution(goodBoard3);
        System.out.println("isFullSolution returned " + flag);
        System.out.println("_____________________________________\n");

        System.out.println("----------------------------------------------------------");
        System.out.println("--------------- End testIsFullSolution() -----------------");
        System.out.println("----------------------------------------------------------\n\n");
    }

    static void testReject() {
        // TODO: Complete this method
        System.out.println("----------------------------------------------------");
        System.out.println("--------------- Begin testReject() -----------------");
        System.out.println("----------------------------------------------------\n\n");

        System.out.println("This test will run through the reject() method and test to see\n"+
                            "if the given board has NO possible further solutions, and return\n"+
                            "true if this is the case. Otherwise, the method will return false.\n"+
                            "Each initial board is displayed, and the return value is given below.\n\n");


        // BE SURE TO PUT IN INITIAL PRINTLN!!!!!

        // Should return TRUE, and should catch it in the little box check
        int testRejectBoard[][] = new int[][] {
          {1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Initial Board:\n");
        printBoard(testRejectBoard);

        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard returned " + reject(testRejectBoard));
        System.out.println("_______________________________________________________\n");


        // Should return TRUE, and should catch it in the little box check
        int testRejectBoard1[][] = new int[][] {
          {1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 1, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(testRejectBoard1);

        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard1 returned " + reject(testRejectBoard1));
        System.out.println("_______________________________________________________\n");



        // Should return a TRUE, and checks through the row check in reject()
        int testRejectBoard2[][] = new int[][] {
          {1, 0, 0, 0, 0, 0, 0, 0, 1},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("\nInitial Board:\n");
        printBoard(testRejectBoard2);
        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard2 returned " + reject(testRejectBoard2));
        System.out.println("_______________________________________________________\n");



        // Should return a TRUE, and checks through the column check in reject()
        int testRejectBoard3[][] = new int[][] {
          {1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("\nInitial Board:\n");
        printBoard(testRejectBoard3);
        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard3 returned " + reject(testRejectBoard3));
        System.out.println("_______________________________________________________\n");



        // Should return a FALSE, since it's not to be rejected!
        int testRejectBoard4[][] = new int[][] {
          {1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(testRejectBoard4);

        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard4 returned " + reject(testRejectBoard4));
        System.out.println("_______________________________________________________\n");


        // Should return TRUE, since in same little box
        int testRejectBoard5[][] = new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 2, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 2, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(testRejectBoard5);

        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard5 returned " + reject(testRejectBoard5));
        System.out.println("_______________________________________________________\n");



        // Should return TRUE, since in same little box
        int testRejectBoard6[][] = new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 8, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 8}
        };
        System.out.println("\nInitial Board:\n");
        printBoard(testRejectBoard6);

        // I only want to check the very first one...
        System.out.println("\nThe Reject method for testRejectBoard6 returned " + reject(testRejectBoard6));
        System.out.println("_______________________________________________________\n");

        System.out.println("----------------------------------------------------");
        System.out.println("----------------- End testReject()------------------");
        System.out.println("----------------------------------------------------\n\n");
    }

    static void testExtend() {
        // TODO: Complete this method
        System.out.println("----------------------------------------------------");
        System.out.println("--------------- Begin testExtend() -----------------");
        System.out.println("----------------------------------------------------\n\n");

        System.out.println("This test will show how the extend() function handles itself when\n"+
                            "there's an empty array (i.e. all 0s) that is passed in. It will \n"+
                            "fill the array by extending 1s and print the result (and each \n"+
                            "intermediate extension, including row and column). Then, the test\n"+
                            "will try to extend the now-full array and, if null, will print an\n"+
                            "error statement for each attempt. There will be, in total, 81 attempts\n"+
                            "for each of the tests. A counter that's being used is simply to validate\n"+
                            "that the proper amount of extensions were performed, rather than counting.\n\n");

        System.out.println("Trying an empty array:\n\n");
        int Emptyboard[][] = new int[9][9];//Creates an initial array of 0s
        System.out.println("Initial Board:\n");
        printBoard(Emptyboard);
        System.out.println("\n\n");
        for (int i = 0; i < 9; i++){
          for (int j = 0; j < 9; j++){
            if (extend(Emptyboard) == null){
              System.out.println("Null value was returned! Array is full.");
            } else{
              Emptyboard = extend(Emptyboard);
              System.out.println("Extended 1 to row " + i + " col " + j);
            }//end IF
          }//end FOR j
        }//end FOR i

        //Printing out the final board:
        System.out.println("\n\nResult:\n\n");
        printBoard(Emptyboard);

//////////////////////////////////////////////////////////////////////////////////////
// Try it again! Should get entirely null values
      System.out.println("\n\n");
      System.out.println("Trying a full array:\n\n");

      System.out.println("Initial Board:\n");
      printBoard(Emptyboard);
      System.out.println("\n\n");
      //int Emptyboard[][] = new int[9][9];//Creates an initial array of 0s
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          if (extend(Emptyboard) == null){
            System.out.println("Null value was returned! Array is full.");
          } else{
            Emptyboard = extend(Emptyboard);
            System.out.println("Extended 1 to row " + i + " col " + j);
          }//end IF
        }//end FOR j
      }//end FOR i

      //Printing out the final board:
      System.out.println("\n\nResult:\n\n");
      printBoard(Emptyboard);
////////////////////////////////////////////////////////////////////////////////


      System.out.println("\n\nTrying an array partially filled with 2s:\n\n");
      int partialBoard[][] = new int[][] {
        {2, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 2, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 0, 2, 0, 0, 2, 0, 0, 0}
      };
      System.out.println("Initial Board:\n");
      printBoard(partialBoard);
      System.out.println("\n\n");
      int counter = 0;
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){

          if (extend(partialBoard) == null){
            System.out.println("Null value was returned! Array is full.");
          } else{
            partialBoard = extend(partialBoard);
            counter++;
            System.out.println("Extended still alright.");
          }//end ELSE
        }//end FOR j
      }//end FOR i

      System.out.println("Total # of extends: " + counter);
      System.out.println("\n\nResult:\n\n");
      printBoard(partialBoard);

      System.out.println("\n\n----------------------------------------------------");
      System.out.println("------------------ End testExtend()-----------------");
      System.out.println("----------------------------------------------------\n\n");
    }//end testExtend()

    static void testImpossibleBoard(){
      System.out.println("--------------------------------------------------------");
      System.out.println("----------- Begin testImpossibleBoard() ----------------");
      System.out.println("--------------------------------------------------------\n");

       System.out.println("This test is being used to prove that the program will catch\n"+
                          "a board that is impossible to solve. The initial board is printed\n"+
                          "below, and the error message follows.\n"+
                          "PLEASE BE SURE TO DOWNLOAD illegalBoard.su FROM BOX AND\n"+
                          "PLACE IN THE BOARDS FOLDER!\n");

      String[] arguments = {"boards/illegalBoard.su", ""};
      main(arguments);

      System.out.println("\n\n--------------------------------------------------------");
      System.out.println("----------- End testImpossibleBoard() ------------------");
      System.out.println("--------------------------------------------------------\n\n");
    }

    static void testNext() {
        // TODO: Complete this method
        int testingNextFirstCell[][] = new int[9][9];
        testingNextFirstCell[0][0] = 1;
        System.out.println("----------------------------------------------------");
        System.out.println("----------------- Begin testNext() -----------------");
        System.out.println("----------------------------------------------------");


        System.out.println("This test will take a board that has zeros in all but a certain\n"+
                            "cell and increment the value until it hits its maximum of 9. It\n"+
                            "will display the intermediate board at each step until next\n"+
                            "returns a 'null' value, in which the test will print out that it\n"+
                            "returned a null.\n\n");

//        Display Initial Given Board
        System.out.println("Initial Board is as follows: \n\n");
        printBoard(testingNextFirstCell);
        System.out.println("\n\n");



//        Begin testing Next on a given array
        int attempt[][] = testingNextFirstCell;
        counter = 0; //Used just to help view in the command line
        while (attempt != null){
          counter++;
          System.out.println("next " + counter + ": \n");
          attempt = next(attempt);
          if (attempt != null){printBoard(attempt);System.out.println("\n");}
          else{System.out.println("next() returned null.");}
          System.out.println("\n");
        }

        System.out.println("Testing corner cases:   \n");

        System.out.println("-------- Begin top left corner ----------\n");

        int testingNextCorners[][] = new int[][] {
          {1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        System.out.println("Initial Board is as follows: \n\n");
        printBoard(testingNextCorners);
        System.out.println("\n");

        attempt = testingNextCorners;
        counter = 0;
        while (attempt != null){
          counter++;
          System.out.println("next " + counter + ": \n");
          attempt = next(attempt);
          if (attempt != null){printBoard(attempt);System.out.println("\n");}
          else{System.out.println("next() returned null.");}
        }

        System.out.println("-------- End top left corner ------------\n");

        System.out.println("------- Begin top right corner ----------\n");


        int testingNextCorners1[][] = new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0, 2},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        System.out.println("Initial Board is as follows: \n\n");

        printBoard(testingNextCorners1);
        System.out.println("\n");

        attempt = testingNextCorners1;
        counter = 0;
        while (attempt != null){
          counter++;
          System.out.println("next " + counter + ": \n");
          attempt = next(attempt);
          if (attempt != null){printBoard(attempt);System.out.println("\n");}
          else{System.out.println("next() returned null.");}
        }


        System.out.println("------- End top right corner ------------\n");


        System.out.println("------- Begin bottom left corner --------\n");


        int testingNextCorners2[][] = new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {3, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        System.out.println("Initial Board is as follows: \n\n");

        printBoard(testingNextCorners2);
        System.out.println("\n");

        attempt = testingNextCorners2;
        counter = 0;
        while (attempt != null){
          counter++;
          System.out.println("next " + counter + ": \n");
          attempt = next(attempt);
          if (attempt != null){printBoard(attempt);System.out.println("\n");}
          else{System.out.println("next() returned null.");}
        }


        System.out.println("------- End bottom left corner ----------\n");


        System.out.println("------- Begin bottom right corner -------\n");


        int testingNextCorners3[][] = new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 6},
        };
        System.out.println("Initial Board is as follows: \n\n");

        printBoard(testingNextCorners3);
        System.out.println("\n");

        attempt = testingNextCorners3;
        counter = 0;
        while (attempt != null){
          counter++;
          System.out.println("next " + counter + ": \n");
          attempt = next(attempt);
          if (attempt != null){printBoard(attempt);System.out.println("\n");}
          else{System.out.println("next() returned null.");}
        }

        System.out.println("------- End bottom right corner ---------\n\n");

        System.out.println("The test has concluded. It checked for each of the corners of the\n"+
                            "board to ensure that the index was reached for each row and column.\n");


        System.out.println("----------------------------------------------------");
        System.out.println("------------------ End testNext()-------------------");
        System.out.println("----------------------------------------------------\n\n");
    }

    static void printBoard(int[][] board) {
        if (board == null) {
            System.out.println("No assignment");
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                System.out.println("----+-----+----");
            }
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5) {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    static int[][] readBoard(String filename) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        } catch (IOException e) {
            System.err.println("Error reading " + filename);
            e.printStackTrace();
            return null;
        }
        int[][] board = new int[9][9];
        int val = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    val = Integer.parseInt(Character.toString(lines.get(i).charAt(j)));
                } catch (NumberFormatException e) {
                    val = 0;
                }
                board[i][j] = val;
            }
        }
        return board;
    }

    static int[][] solve(int[][] board) {
        if (reject(board)) return null;
        if (isFullSolution(board)) return board;
        int[][] attempt = extend(board);
        while (attempt != null) {
            int[][] solution = solve(attempt);
            if (solution != null) return solution;
            attempt = next(attempt);
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length >= 1 && args[0].equals("-t")) {
            System.out.println("Executing test methods.");
            testIsFullSolution();
            testReject();
            testExtend();
            testNext();
            testImpossibleBoard();
        } else if(args.length >= 1) {
            int[][] board = readBoard(args[0]);
            System.out.println("Initial board:");
            printBoard(board);
            for (int i = 0; i < 9; i++){
              for (int j = 0; j < 9; j++){
                initialBoard[i][j] = board[i][j];
              }
            }
            System.out.println("Solution:");
            int solution[][] = solve(board);
            if (solution != null){printBoard(solution);}
            else{System.out.println("There is no solution to this board. Sorry!");}
            //printBoard(solve(board));
        } else {
            System.err.println("No arguments. Check usage instructions.");
        }
    }
}

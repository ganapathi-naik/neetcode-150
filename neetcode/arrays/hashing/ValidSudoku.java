package neetcode.arrays.hashing;

import java.util.HashSet;
//https://leetcode.com/problems/valid-sudoku/description
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> numSeen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentValue = board[i][j];
                if (currentValue != '.') {
                    if(!numSeen.add(currentValue + " found in row " + i) ||
                       !numSeen.add(currentValue + " found in column " + j) ||
                       !numSeen.add(currentValue + " found in sub box " + i / 3 + "-" + j /3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

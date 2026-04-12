class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++){
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++){
                if(board[row][j] == '.') continue;
                if(set.contains(board[row][j])) return false;
                set.add(board[row][j]);
            } 
        }

        for(int col = 0; col < 9; col++){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                if(board[i][col] == '.') continue;
                if(set.contains(board[i][col])) return false;
                set.add(board[i][col]);
            } 
        }

        for(int box = 0; box < 9; box++){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    int row = (box / 3) * 3 + i;
                    int col = (box % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                } 
            }
        }

        return true;
    }
}

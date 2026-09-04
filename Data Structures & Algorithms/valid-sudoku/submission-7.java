class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1: r=0-2, c=0-2
        // 2: r=0-2, c=3-5
        // 3: r=0-2, c=6-8
        // 4: r=3-5, c=0-2
        // 5: r=3-5, c=3-5
        // 6: r=3-5, c=6-8
        // 7: r=6-8, c=0-2
        // 8: r=6-8, c=3-5
        // 9: r=6-8, c=6-8
        HashMap<Integer, HashSet<Integer>> grids = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> cols = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j]; 
                    int grid = (i/3)*3 + (j/3);
                   
                    grids.computeIfAbsent(grid, k -> new HashSet<Integer>());
                    HashSet<Integer> gridValues = grids.get(grid);
                    if (gridValues.contains(val)) return false;
                    gridValues.add(val);

                    rows.computeIfAbsent(i, k -> new HashSet<Integer>());
                    HashSet<Integer> rowValues = rows.get(i);
                    if (rowValues.contains(val)) return false;
                    rowValues.add(val);

                    cols.computeIfAbsent(j, k -> new HashSet<Integer>());
                    HashSet<Integer> colValues = cols.get(j);
                    if (colValues.contains(val)) return false;
                    colValues.add(val);
                }
            }
        }
        return true;
    }
}

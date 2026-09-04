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
        HashMap<Integer, List<Integer>> grids = new HashMap<>();
        HashMap<Integer, List<Integer>> rows = new HashMap<>();
        HashMap<Integer, List<Integer>> cols = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                   int val = board[i][j]; 
                   int grid = 0;
                   if (i < 3) {
                        if (j < 3) {
                            grid = 1;
                        } else if (j < 6) {
                            grid = 2;
                        } else if (j < 9) {
                            grid = 3;
                        }
                    } else if (i < 6) {
                        if (j < 3) {
                            grid = 4;
                        } else if (j < 6) {
                            grid = 5;
                        } else if (j < 9) {
                            grid = 6;
                        }
                    } else if (i < 9) {
                        if (j < 3) {
                            grid = 7;
                        } else if (j < 6) {
                            grid = 8;
                        } else if (j < 9) {
                            grid = 9;
                        }
                    }

                    grids.computeIfAbsent(grid, k -> new ArrayList<Integer>());
                    List<Integer> gridValues = grids.get(grid);
                    if (gridValues.contains(val)) return false;
                    gridValues.add(val);

                    rows.computeIfAbsent(i, k -> new ArrayList<Integer>());
                    List<Integer> rowValues = rows.get(i);
                    if (rowValues.contains(val)) return false;
                    rowValues.add(val);

                    cols.computeIfAbsent(j, k -> new ArrayList<Integer>());
                    List<Integer> colValues = cols.get(j);
                    if (colValues.contains(val)) return false;
                    colValues.add(val);

                }
            }
        }
        return true;
    }
}

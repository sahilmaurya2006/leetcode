class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        // total sum
        for (int[] r : grid)
            for (int x : r)
                total += x;

        if (total % 2 != 0) return false;

        long target = total / 2, sum = 0;

        // horizontal check
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++)
                sum += grid[i][j];

            if (sum == target) return true; 
        }

        long[] col = new long[n];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                col[j] += grid[i][j];

        sum = 0;
        for (int j = 0; j < n - 1; j++) {
            sum += col[j];

            if (sum == target) return true; 
        }

        return false;
    }
}
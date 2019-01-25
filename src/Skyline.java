/**
 * Created by Huy Nguyen on 1/24/19.
 *
 * 807. Max Increase to Keep City Skyline
 *
 */

public class Skyline
{
    public static int maxIncreaseKeepingSkyline(int[][] grid)
    {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        int ans = 0;

        // get max height of all rows
        for (int i = 0; i < grid.length; i++)
        {
            rowMax[i] = getMaxOfRow(grid[i]);
        }

        // get max height of all columns
        for (int i = 0; i < grid[0].length; i++)
        {
            colMax[i] = getMaxOfColumn(i, grid);
        }

        // calculate height difference and add to sum
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                ans += Math.min(rowMax[r], colMax[c]) - grid[r][c];
            }
        }

        return ans;
    }

    public static int getMaxOfRow(int[] row)
    {
        int max = 0;

        for (int height : row)
        {
            max = Math.max(height, max);
        }

        return max;
    }

    public static int getMaxOfColumn(int col,int[][] grid)
    {
        int max = 0;

        for (int row = 0; row < grid.length; row++)
        {
            max = Math.max(grid[row][col], max);
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]  {   {3, 0, 8, 4},
                                        {2, 4, 5, 7},
                                        {9, 2, 6, 3},
                                        {0, 3, 1, 0}
                                    };
        System.out.println("Max increase: " + maxIncreaseKeepingSkyline(grid));

    }
}

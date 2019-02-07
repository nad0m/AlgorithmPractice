import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Huy Nguyen on 2/6/19.
 */
public class Knapsack
{
    public static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] grid = new int[n+1][W+1];

        for (int row = 0; row <= n; row++)
        {
            for (int col = 0; col <= W; col++)
            {

                if (row == 0 || col == 0)
                    grid[row][col] = 0;
                else if (wt[row-1] <= col)
                    grid[row][col] = Math.max(grid[row-1][col], val[row-1] + grid[row-1][col-wt[row-1]]);
                else
                    grid[row][col] = grid[row-1][col];
            }
        }

        int res = grid[n][W];
        int sum = 0;

        for (int row = n; row > 0 && res > 0; row--)
        {
            if (res != grid[row-1][W])
            {
                System.out.print(row-1 + " ");
                res -= val[row-1];
                W -= wt[row-1];

                sum += val[row-1];

            }

        }

        return sum;
    }

    public static List<Integer[]> threeSum(int[] arr, int sum)
    {
        List<Integer[]> ans = new ArrayList<>(); // list of triplets to return
        Arrays.sort(arr); // sort in ascending order

        int size = arr.length; // size of input array

        for (int i = 0; i <= size-3; i++)
        {
            int k = sum - arr[i]; // remaining sum
            int lo = i + 1;
            int hi = size - 1;

            while (lo < hi)
            {
                // if total of both ends is less than remaining sum, move left pointer forward
                if (arr[lo] + arr[hi] < k)
                    lo++;

                // if total of both ends is greater than remaining sum, move right pointer backwards
                else if (arr[lo] + arr[hi] > k)
                    hi--;

                // both ends add up to sum
                else {
                    // log triplet into answer list
                    Integer[] triplet = new Integer[]{arr[i], arr[lo], arr[hi]};
                    ans.add(triplet);

                    lo++;
                    hi--;
                }
            }
        }

        return ans;
    }


    // Driver program to test above function
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120, 80, 190, 340, 110};
        int wt[] = new int[]{1, 2, 3, 4, 2, 6, 9, 5}; // 6 + 2 + 2 + 1   340 + 190 + 100 + 60
        int  W = 5;
        int n = val.length;

        int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3, 2, 3, 4};
        int sum = 6;

        List<Integer[]> ans = threeSum(arr, sum);

        System.out.println(knapSack(W, wt, val, n));
    }
}

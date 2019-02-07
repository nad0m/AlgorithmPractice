import com.interviews.datastructures.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(countWays(3,0));


    }

    public static int countWays(int stairs, int sticky)
    {
        int[] memo = new int[stairs+1];
        Arrays.fill(memo, -1);

        return countWays(stairs, sticky, memo);
    }

    public static int countWays(int stairs, int sticky, int[] memo)
    {
        // when ball gets stuck
        if (stairs == sticky)
            return 0;

        // when ball reaches ground
        else if (stairs <= 0)
            return 1;

        // check memo
        else if (memo[stairs] > -1)
            return memo[stairs];

        // when step # is even
        else if (stairs % 2 == 0)
        {
            memo[stairs] = countWays(stairs - 1, sticky, memo) + countWays(stairs - 3, sticky, memo) + countWays(stairs - 4, sticky, memo);
            return memo[stairs];
        }

        // when step # is odd
        else {
            memo[stairs] = countWays(stairs - 1, sticky, memo) + countWays(stairs - 2, sticky, memo) + countWays(stairs - 4, sticky, memo);
            return memo[stairs];
        }
    }
}

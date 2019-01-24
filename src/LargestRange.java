/**
 * Created by Huy Nguyen on 1/24/19.
 *
 * Largest Range: Return largest range inside the array
 */

import java.util.Arrays;
import java.util.HashMap;

public class LargestRange {
    public static int[] largestRange(int[] array)
    {
        // Write your code here.
        int[] ans = new int[2];
        int max = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();

        //load hash map
        for (int num : array)
            map.put(num, false);

        for (int num : array) {
            if (!map.get(num)) {
                int checkLowerBound = num;
                int checkUpperBound = num;

                while (map.containsKey(checkLowerBound)) {
                    map.put(checkLowerBound, true);
                    checkLowerBound--;
                }

                while (map.containsKey(checkUpperBound)) {
                    map.put(checkUpperBound, true);
                    checkUpperBound++;
                }

                if (checkUpperBound - checkLowerBound > max) {
                    max = checkUpperBound - checkLowerBound;
                    ans[0] = checkLowerBound + 1;
                    ans[1] = checkUpperBound - 1;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2,6,1,6,4,3,8,64,6,5};

        System.out.println(Arrays.toString(largestRange(arr)));
    }
}

/**
 * Created by Huy Nguyen on 1/23/19.
 */

import java.util.*;

public class TwoSum {

    public static boolean hasSum(int[] nums, int target)
    {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
        {
            if (set.contains(num))
                return true;

            set.add(target-num);
        }

        System.out.println(set.toString());
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {10, 15, 3, -6};
        System.out.println("hasSum: " + hasSum(nums, 17));

    }


}

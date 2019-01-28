/**
 *
 *
 *
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 */

import java.util.Arrays;

public class SmallestMissingPositive
{
    public static int firstMissingPositive(int[] nums)
    {
        if (nums.length == 0)
            return 1;

        int size = separate(nums);

        for (int i = 0; i < size; i++)
        {
            int idx = Math.abs(nums[i]);
            if(idx - 1 >= 0 && idx - 1 < size && nums[idx - 1] > 0)
                nums[idx - 1] = -nums[idx - 1];
        }

        for (int i = 0; i < size; i++)
            if (nums[i] > 0)
                return i+1;

        return size+1;

    }

    private static int separate(int [] nums)
    {
        if (nums.length == 1 && nums[0] == 0)
            return 0;
        int L = 0;
        int R = nums.length-1;

        while (L < R)
        {
            if (nums[R] > 0)
            {
                if (nums[L] < 0)
                {
                    int temp = nums[L];
                    nums[L] = nums[R];
                    nums[R] = temp;

                    R--;
                } else {
                    L++;
                }

            } else {
                R--;
            }
        }

        return L+1;
    }
    // main function
    public static void main (String[] args)
    {
        int arr[] = {7,-8,9,1,2};

        System.out.println(firstMissingPositive(arr));

        System.out.println(Arrays.toString(arr));
    }
}

import java.util.Arrays;

/**
 * Created by Huy Nguyen on 1/24/19.
 *
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,  return an array output
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */


public class ProductExceptSelf
{
    public static int[] productExceptSelf(int[] nums)
    {

        int n = nums.length;
        int[] res = new int[n];
        int right=1,left=1;
        for(int i=0;i<n;i++){
            res[i]=1;
            System.out.println("first pass, res: " + res[i]);
        }
        for (int i=0;i<n;i++) {
            res[i]*=left;
            left*=nums[i];
            System.out.println("second pass, res: " + Arrays.toString(res));
            System.out.println("second pass, left: " + left + "\n");
        }
        for(int i=n-1;i>=0;i--) {
            res[i]*=right;
            right*=nums[i];
            System.out.println("third pass, res: " + Arrays.toString(res));
            System.out.println("third pass, right: " + right + "\n");
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2,3,4,5};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}

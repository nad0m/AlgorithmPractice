/**
 * Created by Huy Nguyen on 1/28/19.
 *
 * // Take an array of integers and return the largest difference between any two elements but only where the first of the two elements is less than the second
 * // [7, 8, 1, 5] => 5 - 1 => 4
 * // [1, 2, 3, 4] => 4 - 1 => 3
 */
public class MaxDifference
{
    public static int maxDiff(int[] arr)
    {
        // can't find difference if there's less than 2 numbers
        if (arr.length < 2)
            return -1;

        int min = arr[0]; // smallest value
        int ans = arr[1] - min; // biggest diff

        for (int i = 1; i < arr.length; i++)
        {
            // update max diff if any
            if (ans < arr[i] - min)
                ans = arr[i] - min;

            // update min if any
            if (min > arr[i])
                min = arr[i];

        }

        return ans;
    }

    public static void main(String[] args)
    {
        int arr[] = {8, 7, 6, 5};


        System.out.println(maxDiff(arr));


    }
}

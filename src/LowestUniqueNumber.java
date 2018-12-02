/**
Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.

Example:
input:  arr = [0, 1, 2, 3]
output: 4
**/


public class LowestUniqueNumber
{
    static int getDifferentNumber(int[] arr) {
        // your code goes here
        boolean[] hash = new boolean[arr.length+1];

        for (int num : arr)
        {
            if (num < arr.length)
            {
                hash[num] = true;
            }
        }

        int ans = 0;

        for (int i = 0; i < hash.length; i++)
        {
            if (hash[i] == false)
            {
                ans = i;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = {0,5,4,1,3,6,2};

        System.out.println(getDifferentNumber(arr));
    }
}

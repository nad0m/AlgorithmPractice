import java.util.Arrays;
import java.util.List;

/**
 * Created by Huy Nguyen on 2/6/19.
 *
 * [-1, 5, 10, 20, 28, 3], [26, 134, 135, 15, 17]
 */
public class AbsoluteDifference
{
    public static int[] findLowestDiffBruteForce(int[] arr1, int[] arr2)
    {
        int first = arr1[0];
        int second = arr2[0];
        int min = Math.abs(second - first);

        for (int i = 0; i < arr1.length; i++)
        {
            for (int j = 0; j < arr2.length; j++)
            {
                if (Math.abs(arr1[i] - arr2[j]) < min)
                {
                    first = arr1[i];
                    second = arr2[j];
                    min = Math.abs(second - first);
                }
            }
        }

        System.out.println(min);
        return new int[]{first, second};
    }

    public static int[] findLowestDiffSorted(int[] arr1, int[] arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // respective pointers
        int first = 0;
        int second = 0;

        int minFirst = first;
        int minSecond = second;
        int min = Integer.MAX_VALUE;

        while (first < arr1.length && second < arr2.length)
        {
            if (min > Math.abs(arr1[first] - arr2[second]))
            {
                min = Math.abs(arr1[first] - arr2[second]);
                minFirst = arr1[first];
                minSecond = arr2[second];
            }

            if (arr1[first] > arr2[second])
                second++;
            else
                first++;
        }


        return new int[]{minFirst, minSecond};
    }

    public static void main(String args[])
    {
        int[] arr1 = new int[]{-1, 5, 10, 20, 28, 3, 33};
        int[] arr2 = new int[]{26, 134, 135, 15, 17, 27, 50, 77, 33};

        System.out.println(Arrays.toString(findLowestDiffSorted(arr1, arr2)));

    }
}

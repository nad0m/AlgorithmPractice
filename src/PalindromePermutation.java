
public class PalindromePermutation
{
    public static boolean isPermutationOfPalindrome(String str)
    {
        int[] hashTable = new int[26];
        int sum = 0;

        for (char c : str.toCharArray())
        {
            int idx = (int)c - 'a';

            if (hashTable[idx] > 0)
            {
                hashTable[idx]--;
                sum--;
            } else {
                hashTable[idx]++;
                sum++;
            }
        }

        return sum <= 1;
    }

    public static void main(String[] args)
    {
        String str = "rrrrraaarrrrr";

        System.out.println(isPermutationOfPalindrome(str));
    }
}

public class Sherlock
{
    public static boolean isHim(String f, String l)
    {
        String F = "BENEDICT";
        String L = "CUMBERBATCH";
        int[] firstHash = new int[26];
        int[] lastHash = new int[26];
        int firstReq = 3;
        int lastReq = 5;

        for (char c : F.toCharArray())
            firstHash[c -'A']++;

        for (char c : L.toCharArray())
            lastHash[c -'A']++;

        for (char c : f.toCharArray())
        {
            if (firstHash[c-'A'] > 0)
            {
                firstReq--;
            }
        }

        for (char c : l.toCharArray())
        {
            if (lastHash[c-'A'] > 0)
            {
                lastReq--;
            }
        }

        return firstReq <= 0 && lastReq <= 0 && f.charAt(0) == 'B' && l.charAt(0) == 'C';
    }

    public static void main(String[] args)
    {
        String first = "BATAXXAT";
        String last = "CURMUDGEON";

        System.out.println(isHim(first,last));
    }
}

/**
 * Created by Huy Nguyen on 1/24/19.
 *
 * 771. Jewels and Stones
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 */

import java.util.*;

public class JewelsAndStones
{

    public static int numJewelsInStones(String J, String S)
    {
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for (char c : J.toCharArray())
            set.add(c);
        for (char c : S.toCharArray())
        {
            if (set.contains(c))
                ans++;
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}

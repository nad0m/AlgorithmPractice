/**
 * Created by Huy Nguyen on 1/24/19.
 *
 * 804. Unique Morse Code Words
 *
 * Given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 *
 * Example:
 *
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 *
 */

import java.util.*;

public class MorseCode
{
    public static int uniqueMorseRepresentations(String[] words)
    {
        String[] dictionary = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();

        for (String word : words)
        {
            StringBuilder trans = new StringBuilder();
            for (char c : word.toCharArray())
            {
                trans.append(dictionary[c - 'a']);
            }

            if (!set.contains(trans.toString()))
            {
                set.add(trans.toString());
            }
        }

        return set.size();
    }

    public static void main(String[] args)
    {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(words));

    }
}

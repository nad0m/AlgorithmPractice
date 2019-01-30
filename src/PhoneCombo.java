/**
 * Created by Huy Nguyen on 1/29/19.
 */

import java.util.*;

public class PhoneCombo
{

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static List<String> letterCombinations(String digits)
    {
        Queue<String> q = new LinkedList<>();
        if (digits.length() < 1)
            return (List) q;

        q.add("");

        for (String num : digits.split(""))
        {
            String letters = phone.get(num);
            int qSize = q.size();

            for (int i = 0; i < qSize; i++)
            {
                String combo = q.poll();

                for (char letter : letters.toCharArray())
                {
                    q.add(combo + letter);
                }

            }
        }

        return (List) q;
    }

    public static void main(String[] args)
    {
        String str = "43556"; // hello

        System.out.println(letterCombinations(str));
    }
}

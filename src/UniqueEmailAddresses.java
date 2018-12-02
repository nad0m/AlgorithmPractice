import java.util.HashSet;
import java.util.Set;

/**

 929. Unique Email Addresses
 Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?

 Example:
 Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 Output: 2
 Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

 **/

public class UniqueEmailAddresses
{

    static int numUniqueEmails(String[] emails)
    {
        Set<String> seen = new HashSet();

        for (String email : emails)
        {
            seen.add(getTrueEmail(email));
        }
        return seen.size();
    }

    static String getTrueEmail(String email)
    {
        return new StringBuilder(getLocalName(email) + getDomain(email)).toString();
    }

    static String getDomain(String email)
    {
        // return second substring
        return "@" + email.split("@")[1];
    }

    static String getLocalName(String email)
    {
        String localName = email.split("\\+")[0];

        localName = localName.replaceAll("\\.", "");

        return localName;
    }

    public static void main(String[] args)
    {
        String[] arr = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(arr));
    }
}

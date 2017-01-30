import java.util.Set;
import java.util.TreeSet;

/**
 * Created by chitwant.singh on 1/24/17.
 */
public class Encoding {

    public static void main(String...args) {
        System.out.println("Output is: " + morseCodes(2,1));
        System.out.println("Output is: " + morseCodes(3,2));
    }

    public static Set<String> morseCodes(int m, int n) {
        Set<String> result = new TreeSet<>();
        int k = m + n;
        char dotDash[];
        dotDash = new char[k];

        for (int i =0; i<k; i++) {
            if(i < m)
                dotDash[i] = '.';
            else
                dotDash[i] = '-';

        }

        String s = String.valueOf(dotDash);
        result = getPermutations(s);
        return result;
    }


    /**
     * anagram
     */
    public static Set<String> getPermutations(String inputString) {
        Set<String> returnSet = new TreeSet<String>();
        Set<String> tempSet;
        String stringWithoutFirstChar;
        char firstChar;

        if (inputString.length() == 0){
            returnSet.add("");
            return returnSet;
        }
        firstChar = inputString.charAt(0);
        stringWithoutFirstChar = inputString.substring(1);
        tempSet = getPermutations(stringWithoutFirstChar);

        for (String s : tempSet) {
            for (int k=0; k<=s.length(); k++){
                returnSet.add(iChar(s, firstChar, k));
            }
        }
        return returnSet;
    }

    public static String iChar(String s, char c, int i) {
        String start = s.substring(0, i);
        String finish = s.substring(i);
        return start + c + finish;
    }
}

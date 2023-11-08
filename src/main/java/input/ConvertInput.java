package input;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class ConvertInput {
    public static int numInput(String input) {
        return charArr2Int(str2CharArr(input));
    }

    public static List<Integer> ListInput(String input) {
        List<Integer> list = new ArrayList<Integer>();
        for (String s : input.split(",")) {
            list.add(parseInt(s));
        }
        return list;
    }

    static int charArr2Int(char[] arr) {
        int num = 0;
        for (char c : arr) {
            int digit = c - '0';
            num *= 10;
            num += digit;
        }
        return num;
    }

    static char[] str2CharArr(String input) {
        char[] c = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            c[i] = input.charAt(i);
        }
        return c;
    }


}

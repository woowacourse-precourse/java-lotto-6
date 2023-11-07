package common;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Convert {
    public static int stringToInteger(String src) {
        try {
            return Integer.parseInt(src);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> splitByComma(String src) {
        StringTokenizer st = new StringTokenizer(src, ",");
        List<Integer> winningNumber = new ArrayList<>();
        while (st.hasMoreTokens()) {
            winningNumber.add(stringToInteger(st.nextToken()));
        }
        return winningNumber;
    }
}

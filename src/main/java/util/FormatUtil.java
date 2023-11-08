package util;


import java.text.DecimalFormat;

public class FormatUtil {
    public static String forWon(int original) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        return decFormat.format(original) + "원";
    }
}

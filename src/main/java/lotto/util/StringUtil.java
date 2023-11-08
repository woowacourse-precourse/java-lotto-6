package lotto.util;

import java.text.DecimalFormat;

public class StringUtil {

    public String ConvertToThousandWonUnit(int number) {
        return DecimalFormat.getInstance().format(number);
    }
}

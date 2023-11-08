package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoNumberFormatter {

    private static final String COMMA = ",";

    private LottoNumberFormatter() {
    }

    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(COMMA));
    }
}

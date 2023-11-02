package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.util.validator.LottoValidator;

public class Parser {
    private Parser() {
        // 인스턴스 생성 방지용
    }

    public static int StringParseInt(String input) {
        LottoValidator.validateNotNull(input);
        LottoValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<String> splitByComma(String input) {
        LottoValidator.validateNotNull(input);
        return Arrays.asList(input.trim().split(","));
    }
}

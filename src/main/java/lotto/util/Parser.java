package lotto.util;

import static lotto.exception.ExceptionMessage.NOT_NUMBER;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class Parser {
    private Parser() {
        // 인스턴스 생성 방지용
    }

    public static int parseMoney(String input) {
        return stringParseInt(input);
    }

    public static List<Integer> parseWinningNumber(String input) {
        return splitByComma(input).stream()
                .map(Parser::stringParseInt)
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String input) {
        int bonusNumber = stringParseInt(input);
        LottoValidator.validateInRange(bonusNumber);
        return bonusNumber;
    }

    private static int stringParseInt(String input) throws LottoException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(NOT_NUMBER, e);
        }
    }

    private static List<String> splitByComma(String input) {
        return Arrays.asList(input.trim().split(","));
    }
}

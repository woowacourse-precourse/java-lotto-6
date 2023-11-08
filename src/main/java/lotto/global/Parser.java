package lotto.global;

import static lotto.global.Constants.DELIMITER;

import java.util.Arrays;
import lotto.domain.Lotto;

public class Parser {
    public static Lotto parseStringToLotto(String input) {
        return Lotto.of(
                Arrays.stream(input.split(DELIMITER))
                        .map(String::trim)
                        .map(Parser::parseStringToUnsignedInt)
                        .toList()
        );
    }

    public static int parseStringToUnsignedInt(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessages.NUMBER_FORMAT_ERROR.getValue());
        }
    }
}
package lotto.domain.lottery;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.List;

public class Jackpot {
    private static final String DELIMITER = ",";

    private final List<JackpotNumber> numbers;

    private Jackpot(final List<JackpotNumber> jackpotNumbers) {
        this.numbers = jackpotNumbers;
    }

    public static Jackpot from(final List<JackpotNumber> jackpotNumbers) {
        return new Jackpot(jackpotNumbers);
    }

    public static void validateEndsWithComma(final String input) {
        if (isEndsWithDelimiter(input)) {
            throw LottoException.from(ErrorMessage.ENDS_WITH_DELIMITER);
        }
    }

    private static boolean isEndsWithDelimiter(String input) {
        return input.endsWith(DELIMITER);
    }

    public List<JackpotNumber> getNumbers() {
        return numbers;
    }
}

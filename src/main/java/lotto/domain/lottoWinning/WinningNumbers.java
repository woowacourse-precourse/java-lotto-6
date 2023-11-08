package lotto.domain.lottoWinning;

import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorMessagePrinter;
import lotto.exception.LottoExceptionMessage;

public class WinningNumbers {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int EXPECTED_COUNT = 6;
    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(List<Integer> winningNumbers) {
        try {
            return new WinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            ErrorMessagePrinter.printError(e);
            return null;
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.stream().toList();
    }

    private void validate(List<Integer> winningNumbers) {
        isSixUniqueNumbers(winningNumbers);
        isBetweenStartAndEndInclusive(winningNumbers);
    }

    private void isSixUniqueNumbers(List<Integer> winningNumbers) {
        HashSet<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() != EXPECTED_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_SIX_DIGITS.getMessage());
        }
    }

    private void isBetweenStartAndEndInclusive(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number < START_INCLUSIVE || number > END_INCLUSIVE)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessage.WINNING_NUMBERS_MUST_BETWEEN_START_AND_END_INCLUSIVE.getMessage());
        }
    }

}

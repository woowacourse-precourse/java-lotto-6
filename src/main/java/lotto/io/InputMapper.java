package lotto.io;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputMapper {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public PurchaseAmount toPurchaseAmount(final String input) {
        return new PurchaseAmount(Integer.parseInt(input));
    }

    public WinningNumbers toWinningNumbers(final String input) {
        return Arrays.stream(input.split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningNumbers::new));
    }
}

package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputMapper {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public PurchaseAmount toPurchaseAmount(final String input) {
        return new PurchaseAmount(Integer.valueOf(input));
    }

    public WinningNumbers toWinningNumbers(final String input) {
        return Arrays.stream(input.split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningNumbers::new));
    }

    public BonusNumber toBonusNumber(final String input) {
        return new BonusNumber(Integer.valueOf(input));
    }
}

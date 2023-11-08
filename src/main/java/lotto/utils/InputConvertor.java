package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.InputConstants;
import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class InputConvertor {

    private static int convertStringtoInt(final String input) {
        return Integer.parseInt(input);
    }

    public static Money convertMoney(final String input) {
        return Money.from(convertStringtoInt(input));
    }

    public static Bonus convertBonus(final String input) {
        return Bonus.from(convertStringtoInt(input));
    }

    public static WinningLotto convertWinnings(final String input) {
        List<String> numbers = splitWinnings(input);
        List<Integer> winningNumbers = numbers.stream().
                map(InputConvertor::convertStringtoInt)
                .collect(Collectors.toList());
        return WinningLotto.createWinningLottos(winningNumbers);
    }

    public static List<String> splitWinnings(final String input) {
        return Arrays.asList(input.split(InputConstants.WINNING_DELIMITER.getConstants()));
    }

}

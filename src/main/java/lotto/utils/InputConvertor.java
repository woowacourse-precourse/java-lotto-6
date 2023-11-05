package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class InputConvertor {

    private static final String WINNING_DELIMITER = ",";

    private static int convertStringtoInt(String input) {
        return Integer.parseInt(input);
    }

    public static Money convertMoney(String input) {
        return Money.from(convertStringtoInt(input));
    }

    public static Bonus convertBonus(String input) {
        return Bonus.from(convertStringtoInt(input));
    }

    public static WinningLotto convertWinnings(String input) {
        List<String> numbers = splitWinnings(input);
        List<Integer> winningNumbers = numbers.stream().
                map(InputConvertor::convertStringtoInt)
                .collect(Collectors.toList());
        return WinningLotto.createWinningLottos(winningNumbers);
    }

    public static List<String> splitWinnings(String input) {
        return Arrays.asList(input.split(WINNING_DELIMITER));
    }

}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoGameRule;
import lotto.exception.InvalidSizeException;
import lotto.exception.NonNumericAmountException;

public class InputView {

    public static int readMoney() {
        String money = Console.readLine();
        return convertToInt(money);
    }

    public static List<Integer> readWinningNumbers() {
        String winningNumbers = Console.readLine();

        Parser parser = new CommaParser();
        List<String> numbers = parser.split(winningNumbers);

        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(convertToInt(number));
        }

        if (list.size() != LottoGameRule.LOTTO_SIZE.value()) {
            throw new InvalidSizeException();
        }

        return list;
    }

    private static int convertToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NonNumericAmountException();
        }
    }
}


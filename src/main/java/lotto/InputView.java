package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoGameRule;
import lotto.exception.InvalidSizeException;
import lotto.exception.NonNumericAmountException;

public class InputView {


    private final InputReceiver receiver;

    public InputView(InputReceiver receiver) {
        this.receiver = receiver;
    }

    private static int convertToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NonNumericAmountException();
        }
    }

    public int getMoney() {
        String money = receiver.readLine();
        return convertToInt(money);
    }

    public List<Integer> getWinningNumbers() {
        String winningNumbers = receiver.readLine();

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
}


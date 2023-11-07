package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoGameMessage;
import lotto.config.LottoGameRule;
import lotto.exception.InvalidSizeException;
import lotto.exception.NonNumericAmountException;

public class InputView {


    private final InputReceiver receiver;

    public InputView(InputReceiver receiver) {
        this.receiver = receiver;
    }

    public Money getMoney() {
        System.out.println(LottoGameMessage.INPUT_GET_MONEY.message());

        int money = inputMoney();
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
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

    private int inputMoney() {
        try {
            String money = receiver.readLine();
            return convertToInt(money);
        } catch (NonNumericAmountException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private int convertToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NonNumericAmountException();
        }
    }
}


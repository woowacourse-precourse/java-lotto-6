package lotto.domain;

import static lotto.domain.constant.CommonMessage.INPUT_ERROR_MESSAGE;

import java.util.Arrays;
import lotto.domain.constant.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Money {
    public static final int UNIT_PRICE = 1000;
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final int money;

    Money(int money) {
        validate(money);
        this.money = money;
    }

    public static Money createMoney() {
        try {
            return inputMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(INPUT_ERROR_MESSAGE.getValue());
            return createMoney();
        }
    }

    private static Money inputMoney() {
        OutputView.printMessage(MONEY_INPUT_MESSAGE);
        String input = InputView.readMessage();
        OutputView.printMessage();
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE.getValue());
        }
        return new Money(money);
    }

    private void validate(int money) {
        if (money % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE.getValue());
        }
    }

    public static Money from(LottoResults lottoResults) {
        return new Money(Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .mapToInt(rank -> rank.getPrice() * lottoResults.getRankCount(rank))
                .sum()
        );
    }

    public int getMoney() {
        return money;
    }
}

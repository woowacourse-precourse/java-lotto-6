package lotto.View.InputView;

import static lotto.Model.CountLotto.PURCHASE_UNIT;
import static lotto.View.SystemMessage.ERROR_INVALID_INPUT;
import static lotto.View.SystemMessage.ERROR_INVALID_LOTTO_AMOUNT;
import static lotto.View.SystemMessage.GUESS_BUY_LOTTO;

import camp.nextstep.edu.missionutils.Console;

public class InputBuyLotto {

    private final int lottoAmount;

    public InputBuyLotto() {
        System.out.println(GUESS_BUY_LOTTO.getMessage());
        this.lottoAmount = buyLotto();
        System.out.println();
    }

    private int buyLotto() {
        int result;
        while (true) {
            try {
                String input = Console.readLine();
                result = validateInput(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }

    private int validateInput(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
            if (result % PURCHASE_UNIT != 0)
                throw new IllegalArgumentException(ERROR_INVALID_LOTTO_AMOUNT.getMessage());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT.getMessage());
        }

        return result;
    }

    public int getAmountLotto() {
        return this.lottoAmount;
    }


}

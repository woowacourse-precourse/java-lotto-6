package lotto.View;

import static lotto.View.SystemMessage.ERROR_INVALID_INPUT;
import static lotto.View.SystemMessage.ERROR_INVALID_LOTTO_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputBuyLotto {

    private final int lotto;

    public InputBuyLotto() {
        lotto = buyLotto();
    }

    private int buyLotto() {
        int result = 0;
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
        int result = 0;
        try {
            result = Integer.parseInt(input);
            if (result % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_INVALID_LOTTO_AMOUNT.getMessage());
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT.getMessage());
        }

        return result;
    }

    public int getLotto () {
        return lotto;
    }


}

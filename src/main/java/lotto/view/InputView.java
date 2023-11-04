package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BuyAmount;
import lotto.utils.validator.Validator;

public class InputView {

    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";

    private InputView() {
    }

    public static BuyAmount getBuyAmountFromInput() {
        try {
            String buyAmount = read();
            Validator.validateEmpty(buyAmount);
            return new BuyAmount(Long.parseLong(buyAmount));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    private static String read() {
        return Console.readLine().trim();
    }
}

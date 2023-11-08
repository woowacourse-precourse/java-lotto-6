package lotto.view;

import lotto.domain.Money;

import java.util.regex.Pattern;

public class InputMoneyView extends InputView {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 숫자만 입력할 수 있습니다.";
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public String getInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = inputValue();
        System.out.println();
        try {
            Money.validate(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            input = getInputMoney();
        }
        return input;
    }
}

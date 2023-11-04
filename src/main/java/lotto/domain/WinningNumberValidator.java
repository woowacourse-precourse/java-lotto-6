package lotto.domain;

import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;

import java.util.List;

public class WinningNumberValidator {

    private void checkValidInteger(List<String> numbers) {
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NON_INTEGER_MONEY.getMessage());
            }
        }
    }
}

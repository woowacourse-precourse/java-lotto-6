package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.ui.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public Money getMoney() {
        String input = getInput();
        return new Money(validateNumber(input));
    }

    private Integer validateNumber(String input) {

        if (!isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getComment());
        }

        return Integer.parseInt(input);
    }

    private boolean isNumber(String input) {
        return input.chars().allMatch(initial -> (initial >= '0' && initial <= '9'));
    }

    private String getInput() {
        return Console.readLine();
    }


}

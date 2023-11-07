package lotto.UI;

import lotto.utils.Validator;
import lotto.constants.ErrorMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {
    public String inputCost() {
        String input;

        while (true) {
            try {
                System.out.println("구입금액을 입력해주세요.");
                input = readLine();
                if (costValidate(input)) break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private boolean costValidate(String input) {
        if (Validator.isNull(input)) throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getError());
        if (Validator.isBlank(input)) throw new IllegalArgumentException(ErrorMessage.BLANK_ERROR.getError());
        if (Validator.isContainBlank(input))
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_BLANK_ERROR.getError());
        if (!Validator.isNumber(input)) throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getError());
        if (Validator.underByLottoPrice(input))
            throw new IllegalArgumentException(ErrorMessage.UNDER_LOTTO_PRICE_ERROR.getError());
        if (!Validator.isDivisibleByLottoSize(input))
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_1000_ERROR.getError());

        return true;
    }
}

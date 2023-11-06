package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import lotto.constant.Message;
import lotto.exception.LottoExceptionMessage;

public class InputView {
    public int inputPrice() {
        Integer validPrice = null;

        while (isNotValidPrice(validPrice)) {
            System.out.println(Message.INPUT_PRICE.getMessage());
            String inputPrice = Console.readLine().trim();
            validPrice = parseValidPrice(inputPrice);
        }
        return validPrice;
    }

    private boolean isNotValidPrice(Integer validPrice) {
        return Objects.isNull(validPrice);
    }

    private Integer parseValidPrice(String inputPrice) {
        try {
            if (isNumber(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.MUST_BE_NUMBER.getMessage());
        }
        return null;
    }

    private boolean isNumber(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.MUST_BE_NUMBER.getMessage());
        }
    }
}

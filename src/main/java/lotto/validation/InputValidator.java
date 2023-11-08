package lotto.validation;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidPurchasePriceException;

import java.util.StringTokenizer;

import static lotto.constants.Lotto.COST;

public class InputValidator {

    public static final InputValidator validator = new InputValidator();

    private InputValidator() {}

    public static InputValidator getInstance() {
        return validator;
    }

    public void purchasePrice(String purchasePrice) {
        integerCheck(purchasePrice);
        int castedPrice = Integer.parseInt(purchasePrice);

        minimumPriceCheck(castedPrice);
        divisibleCheck(castedPrice);
    }

    public void lottoNumber(String lottoNumber) {
        delimiterCheck(lottoNumber);
    }

    private static void integerCheck(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getLabeledErrorMessage());
        }
    }

    private void minimumPriceCheck(int totalPrice) {
        if(totalPrice < COST.getValue()) {
            throw new InvalidPurchasePriceException(ErrorMessage.OUT_OF_PRICE_RANGE.getLabeledErrorMessage());
        }
    }

    /**
     * 복권 한 장 가격 단위로 입력되었는지 검증
     */
    private void divisibleCheck(int totalPrice) {
        if(totalPrice % COST.getValue() != 0) {
            throw new InvalidPurchasePriceException(ErrorMessage.NOT_DIVISIBLE_TICKET_PRICE.getLabeledErrorMessage());
        }
    }

    private static void delimiterCheck(String lottoNumber) {
        StringTokenizer st = new StringTokenizer(lottoNumber, ",");
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            integerCheck(number);
        }
    }
}

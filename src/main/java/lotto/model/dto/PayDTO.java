package lotto.model.dto;
import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_PAYMENT;

import lotto.constants.ExceptionMessages;
import lotto.model.validator.PaymentValidator;

public class PayDTO {
    private static final int PRICE_OF_LOTTO = 1000;
    private int payment;
    private PayDTO(int payment){
        this.payment = payment;
    }

    public static PayDTO from(String text){
        return new PayDTO(Integer.parseInt(text));
    }

    public int getNumberOfLotto(){
        return payment / PRICE_OF_LOTTO;
    }



    public int getPayment() {
        return payment;
    }
}

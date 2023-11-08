package lotto.dto;

import lotto.exception.LottoGameException;
import lotto.utils.Parser;

import static lotto.validator.LottoValidator.*;

public class Payment {
    private int payment;

    private Payment(String inputValue) throws LottoGameException {
        validateNullValue(inputValue);
        validateNoRemainderValue(this.payment);
        this.payment = Parser.parseStringToInt(inputValue);
    }

    public static Payment create(String inputValue) throws LottoGameException {
        return new Payment(inputValue);
    }

    public int getPayment() {
        return this.payment;
    }
}

package lotto.input.Validator;

import static lotto.input.constant.Constant.LOTTO_PRICE;

public class AmountInputValidate {

    public Long valueValidate(String value) {
        Long amount = isNumber(value);
        isDivided1000(amount);
        return amount;
    }

    public void isDivided1000(Long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public Long isNumber(String amount) {
        long number;
        try {
            number = Long.parseLong(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return number;
    }

}

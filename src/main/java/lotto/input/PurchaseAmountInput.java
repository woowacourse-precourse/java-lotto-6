package lotto.input;

import static lotto.constant.Constant.LOTTO_PRICE;
import static lotto.constant.Constant.PURCHASE_AMOUNT_INPUT_ERROR;
import static lotto.constant.Constant.PURCHASE_AMOUNT_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator.AmountInputValidate;

public class PurchaseAmountInput {
    private final AmountInputValidate inputValidate = new AmountInputValidate();

    public Integer userAmountInput() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return validateCheck();
    }

    public Integer validateCheck() {
        Long amount;
        while (true) {
            try {
                String value = Console.readLine();
                amount = inputValidate.valueValidate(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(PURCHASE_AMOUNT_INPUT_ERROR);
            }
        }
        return getCount(amount);
    }

    private int getCount(Long amount) {
        return amount.intValue() / LOTTO_PRICE;
    }


}

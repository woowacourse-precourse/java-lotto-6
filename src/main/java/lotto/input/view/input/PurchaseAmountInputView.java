package lotto.input.view.input;

import static lotto.input.constant.Constant.PURCHASEAMOUNTINPUT;
import static lotto.input.constant.Constant.PURCHASEAMOUNTINPUT_ERROR;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.Validator.InputValidate;

public class PurchaseAmountInputView {
    private final InputValidate inputValidate = new InputValidate();

    public Integer userAmountInput() {
        System.out.println(PURCHASEAMOUNTINPUT);
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
                System.out.println(PURCHASEAMOUNTINPUT_ERROR);
            }
        }
        return getCount(amount);
    }

    private int getCount(Long amount) {
        return amount.intValue() / 1000;
    }


}

package lotto.input.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.Validator.InputValidate;

public class PurchaseAmountInputView {
    private final InputValidate inputValidate = new InputValidate();

    public Long userAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return validateCheck();
    }

    public Long validateCheck() {
        Long amount = null;
        while (true) {
            try {
                String value = Console.readLine();
                amount = inputValidate.valueValidate(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바르지 않는 값을 입력했습니다. 1000의 배수의 가격을 입력해주세요.");
            }
        }
        return amount;
    }


}

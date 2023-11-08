package view;

import camp.nextstep.edu.missionutils.Console;
import domain.AmountValidate;

public class InputView {

    private final AmountValidate amountInput = new AmountValidate();

    public void printRequestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Integer InputAmount() {
        String amount = Console.readLine();

        try {
            amountInput.validateAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputAmount();
        }
        return Integer.parseInt(amount);
    }

    public void InputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}

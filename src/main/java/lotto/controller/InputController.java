package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_SIX_DIGITS_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final InputValidatorController inputValidatorController;

    public InputController() {
        this.inputValidatorController = new InputValidatorController();
    }
    public String purchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        inputValidatorController.blank(purchaseAmount);

        return purchaseAmount;
    }

    public String numbers() {
        System.out.println(ENTER_SIX_DIGITS_NUMBERS);
        String numbers = Console.readLine();
        inputValidatorController.blank(numbers);

        return numbers;
    }

    public String bonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        inputValidatorController.blank(bonusNumber);

        return bonusNumber;
    }
}

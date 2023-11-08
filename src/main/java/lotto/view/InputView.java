package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSASE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER_MESSASE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSASE = "보너스 번호를 입력해 주세요.";
    private final String DIVISION_STANDARD = ",";

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSASE);
        String purchaseAmount = getUserInput();
        inputValidator.validateUserInput(purchaseAmount);
        return purchaseAmount;
    }

    public String inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSASE);
        String userInput = getUserInput();
        String winningNumber = userInput.replaceAll(DIVISION_STANDARD, "");
        inputValidator.validateUserInput(winningNumber);
        return userInput;
    }

    public String inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSASE);
        String bonusNumber = getUserInput();
        inputValidator.validateUserInput(bonusNumber);
        return bonusNumber;
    }

    private String getUserInput() {
        return Console.readLine().trim();
    }
}

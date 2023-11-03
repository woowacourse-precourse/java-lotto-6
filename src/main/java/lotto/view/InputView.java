package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String ERROR = "[ERROR] ";

    public int receivePurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(ERROR + "입력값이 존재하지 않습니다.");
        }
        if (!purchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR + "입력 형식이 올바르지 않습니다.");
        }
    }

    public String receiveWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        return winningNumber;
    }

    public int receiveBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}

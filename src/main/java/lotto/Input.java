package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    Exception exception = new Exception();

    public int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        String purchasePrice = consoleReadLine();
        exception.validatePurchasePrice(purchasePrice);
        return Integer.parseInt(purchasePrice);
    }

    public void inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String winningNumbers = consoleReadLine();
        exception.validateWinningNumbers(winningNumbers);
    }

    private String consoleReadLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String EXCEPTION_MESSAGE = "[ERROR] %s\n";


    @Override
    public String getPurchaseAmount() {
        System.out.println();
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    @Override
    public void displayException(String message) {
        System.out.println();
        System.out.printf(EXCEPTION_MESSAGE, message);
    }
}

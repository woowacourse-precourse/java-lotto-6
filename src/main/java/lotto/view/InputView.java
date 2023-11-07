package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String MESSAGE_GET_PRICE = "구입 금액을 입력해 주세요.";
    static final String MESSAGE_GET_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String MESSAGE_GET_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String getPayment() {
        System.out.println("\n" + MESSAGE_GET_PRICE);
        String paymentInput = Console.readLine();
        return paymentInput;
    }

    public String getWinningNumbers() {
        System.out.println("\n" + MESSAGE_GET_WINNING_NUMBER);
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public String getBonusNumber() {
        System.out.println("\n" + MESSAGE_GET_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPayment() {
        System.out.println("\n구입 금액을 입력해주세요.");
        String paymentInput = Console.readLine();
        return paymentInput;
    }

    public String getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public String getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}

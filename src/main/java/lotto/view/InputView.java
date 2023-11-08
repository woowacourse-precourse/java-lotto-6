package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        String purchaseAmountString = Console.readLine();
    }

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");

        String winningNumbersString = Console.readLine();
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");

        String bonusNumberString = Console.readLine();
    }
}

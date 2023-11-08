package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        return purchasePrice;
    }

    public String requestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        return winningNumbers;
    }

    public String requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumbers = Console.readLine();

        return bonusNumbers;
    }
}

package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    public String readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    public String readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String readWinningNumber() {
        LottoOutputView.lineBreak();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        LottoOutputView.lineBreak();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

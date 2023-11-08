package lotto.view;

import lotto.model.Lotto;

public class OutputView {

    public void printPaymentInstruction() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPurchaseAmount(int payment) {
        int amountOfLotto = payment / 1000;
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printWinningNumberInstruction() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInstruction() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    
}

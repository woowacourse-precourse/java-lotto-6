package lotto.outputPrint;

import lotto.readUserInput.PurchaseAmount;

public class GameGuidePrint {
    public void scanPurchasePrint() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void purchaseCompletePrint() {
        int theNumberOfLotto = PurchaseAmount.lottoQuantity;
        System.out.println(theNumberOfLotto + "개를 구매했습니다.");
    }

    public void scanWinningNumberPrint() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void scanBonusNumberPrint() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void resultGame() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}

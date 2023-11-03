package lotto.userInterface;

import lotto.domain.Lotto;

public class OutputViewer {
    private OutputViewer() {
    }

    public static void printRequestAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printCountOfPurchaseLottos(int countOfLottos) {
        System.out.println(countOfLottos + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(Lotto lotto) {
        System.out.println(lotto.showNumbers());
    }

    public static void printRequestWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}

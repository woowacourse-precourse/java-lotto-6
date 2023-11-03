package lotto.userInterface;

import lotto.domain.Lotto;

public class OutputViewer {
    private OutputViewer() {
    }

    public static void printRequestAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedCountOfLottos(int countOfLottos) {
        System.out.println(countOfLottos + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(Lotto lotto) {
        System.out.println(lotto.showNumbers());
    }
}

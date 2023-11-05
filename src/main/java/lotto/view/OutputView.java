package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public static void printPurchaseAmountRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int LottoCount) {
        System.out.print(LottoCount + "개를 구매했습니다.\n");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printNextLine() {
        System.out.print("\n");
    }
}

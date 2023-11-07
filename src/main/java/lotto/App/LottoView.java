package lotto.App;

import java.util.List;
import lotto.Domain.Lotto;

public class LottoView {

    public void inputBudgets() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedCnt(String purchaseCnt) {
        System.out.println("\n" + purchaseCnt + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}

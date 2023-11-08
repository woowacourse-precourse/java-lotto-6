package lotto.view;

import lotto.domain.Lottos;

/**
 * 구매한 Lotto의 갯수를 보여주는 view
 */
public class OutputPurchaseView {
    /**
     * 구매한 로또의 갯수와 로또들의 수를 보여준다.
     *
     * @param amount 구매한 Lotto 갯수
     * @param lottos 구매한 Lotto들이 들어있는 Lottos
     */
    public void printPurchaseLotto(int amount, Lottos lottos) {
        System.out.println(amount + "개를 구매했습니다.");
        lottos.printLottos();
        System.out.println();
    }
}

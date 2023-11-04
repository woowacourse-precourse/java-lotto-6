package lotto.view;

import lotto.Lotto;

import java.util.List;

public class LottoOutputView {
    public void printBuyingPriceInputRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printBoughtResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}

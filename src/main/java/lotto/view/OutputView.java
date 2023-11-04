package lotto.view;

import lotto.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoCount(int purchasedCount) {
        System.out.printf(String.format("%d개를 구매했습니다.", purchasedCount));
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}

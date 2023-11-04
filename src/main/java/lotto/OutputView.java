package lotto;

import java.util.List;

public class OutputView {
    public void printCreateLottoNumbers(final List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}

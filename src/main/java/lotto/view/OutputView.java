package lotto.view;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class OutputView {

    public void printLottoOrder(List<Lotto> lottos) {
        printLottoCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

}

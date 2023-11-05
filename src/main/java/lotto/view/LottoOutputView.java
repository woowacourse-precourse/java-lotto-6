package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class LottoOutputView {
    private static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";

    public void printPublishedLottos(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_PHRASE);
        for (Lotto lotto : lottos) {
            lotto.printItself();
        }
    }
}

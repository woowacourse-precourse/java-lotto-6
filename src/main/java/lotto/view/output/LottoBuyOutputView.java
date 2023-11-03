package lotto.view.output;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class LottoBuyOutputView {

    private final String PURCHASED_LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";

    public void printPurchaseLottoCountMessage(Lottos lottos) {
        System.out.println(String.format(PURCHASED_LOTTO_COUNT_MESSAGE, lottos.size()));
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.lottoNumbersAsString());
    }

}

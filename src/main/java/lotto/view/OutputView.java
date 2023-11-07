package lotto.view;

import static lotto.util.OutputEnum.PUBLISHED_LOTTO_COUNT_OUTPUT;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class OutputView {

    public void printPublishedLottoCount(int lottoCount) {
        System.out.println(lottoCount + PUBLISHED_LOTTO_COUNT_OUTPUT.message());
    }

    public void printPublishedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printWinningResult() {

    }

    public void printEarningRate() {

    }

}

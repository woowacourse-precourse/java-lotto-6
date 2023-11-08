package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoStatistic;

public class OutputView {
    public static void printLottos(LottoGame lottoGame) {
        System.out.println();
        System.out.println(lottoGame.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.getLottos()) {
            System.out.println(lotto);
        }
    }
    public static void printStatistic(LottoGame lottoGame) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoGame.lottoResultToString();
        lottoGame.lottoRateToString();
    }
}

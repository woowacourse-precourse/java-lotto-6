package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class OutputView {
    public static void printLottos(LottoGame lottoGame) {
        System.out.println(lottoGame.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.getLottos()) {
            System.out.println(lotto);
        }
    }
}

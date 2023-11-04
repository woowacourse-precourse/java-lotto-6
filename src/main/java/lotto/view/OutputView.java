package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    public static void printMyLotto(Lottos lottos) {
        System.out.println(getWinningResultMessage(lottos.getLottoCount()));
        printLottoList(lottos);
    }

    private static void printLottoList(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    private static String getWinningResultMessage(int count) {
        return count + ViewConstraints.PURCHASED_LOTTOS.getMessage();
    }
}

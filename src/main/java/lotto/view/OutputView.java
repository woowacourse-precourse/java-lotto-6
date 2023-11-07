package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(OUTPUT_LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public void printWinningLottos(List<Lotto> winningLottos) {
        for(Lotto lotto : winningLottos) {
            System.out.println(lotto);
        }
    }

}

package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String LOTTO_COUNT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVISION_LINE = "---";

    public void showLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT);
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void showWinningStatistic() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION_LINE);
    }
}

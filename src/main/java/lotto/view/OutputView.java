package lotto.view;

import lotto.model.prize.Prize;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String PRIZE_STATISTICS_MESSAGE =
            """
            \n당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            """;
    private static final String PRIZE_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public void printLotto(String lotto) {
        System.out.println(lotto);
    }

    public void printPrizeResult(Prize prize) {
        System.out.printf(PRIZE_STATISTICS_MESSAGE,
                prize.threeMatchCount(),
                prize.fourMatchCount(),
                prize.fiveMatchCount(),
                prize.fiveMatchWithBonusCount(),
                prize.sixMatchCount()
        );
    }

    public void printPrizeRate(double prizeRate) {
        System.out.printf(PRIZE_RATE_MESSAGE, prizeRate);
    }
}

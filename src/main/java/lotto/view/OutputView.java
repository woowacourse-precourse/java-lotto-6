package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottosPurchased;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    public void printNumberOfLottosPurchased(LottosPurchased lottosPurchased) {
        int numberOfLottos = lottosPurchased.getNumberOfLottos();

        System.out.println(numberOfLottos + NUMBER_OF_LOTTOS_MESSAGE);
    }

    public void printLottosPurchased(LottosPurchased lottosPurchased) {
        int numberOfLottos = lottosPurchased.getNumberOfLottos();

        for (int i = 0; i < numberOfLottos; i++) {
            System.out.println(lottosPurchased.getLotto(i));
        }
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(getMessage(lottoStatistics, LottoRank.FIFTH_PRIZE));
        System.out.println(getMessage(lottoStatistics, LottoRank.FOURTH_PRIZE));
        System.out.println(getMessage(lottoStatistics, LottoRank.THIRD_PRIZE));
        System.out.println(getMessage(lottoStatistics, LottoRank.SECOND_PRIZE));
        System.out.println(getMessage(lottoStatistics, LottoRank.FIRST_PRIZE));
    }

    private String getMessage(LottoStatistics lottoStatistics, LottoRank lottoRank) {
        return lottoRank.getMessageWith(lottoStatistics.getCountOf(lottoRank));
    }
}

package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.util.ModelAndViewConverter;
import lotto.domain.lottoresult.LottoResult;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String STATISTICS_NUMBER_OF_SAME = "%d개 일치";
    private static final String STATISTICS_PRIZE_AND_COUNT = " (%,d원) - %d개\n";
    private static final String STATISTICS_BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_MESSAGE = "총 수익률은 %,.1f%%입니다.";
    private static final String ERROR_START_MESSAGE = "[ERROR]";

    public void printTotalNumberOfLotto(ModelAndViewConverter modelAndViewConverter) {
        System.out.printf(NUMBER_OF_LOTTO_MESSAGE, modelAndViewConverter.getNumberOfLottoBundle());
    }

    public void printTotalLotto(ModelAndViewConverter modelAndViewConverter) {
        for (String lottoMessage : modelAndViewConverter.getLottoMessages()) {
            System.out.println(lottoMessage);
        }
    }

    public void printLottoResultsData(ModelAndViewConverter modelAndViewConverter) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        Map<LottoResult, Integer> lottoResultsData = modelAndViewConverter.getLottoResultsData();
        List<LottoResult> sortedLottoResultsByKey = getSortedLottoResults(lottoResultsData);
        for (LottoResult lottoResult : sortedLottoResultsByKey) {
            if (lottoResult.isNone()) {
                continue;
            }
            int numberOfSame = lottoResult.getNumberOfSame();
            long prizeMoney = lottoResult.getPrizeMoney();
            int count = lottoResultsData.get(lottoResult);

            String message = makeWinningStatisticsMessage(lottoResult);
            System.out.printf(message, numberOfSame, prizeMoney, count);
        }
    }

    private List<LottoResult> getSortedLottoResults(Map<LottoResult, Integer> lottoResultsData) {
        List<LottoResult> lottoResultsByKey = new ArrayList<>(lottoResultsData.keySet());
        Collections.sort(lottoResultsByKey);
        return lottoResultsByKey;
    }

    private String makeWinningStatisticsMessage(LottoResult lottoResult) {
        String bonusBallMessage = getBonusBallMessage(lottoResult);
        return STATISTICS_NUMBER_OF_SAME + bonusBallMessage + STATISTICS_PRIZE_AND_COUNT;
    }

    private String getBonusBallMessage(LottoResult lottoResult) {
        if (lottoResult.isSecond()) {
            return STATISTICS_BONUS_BALL_MATCH;
        }
        return "";
    }

    public void printProfit(ModelAndViewConverter modelAndViewConverter) {
        double profitMessage = modelAndViewConverter.getProfitMessage();
        System.out.printf(PROFIT_MESSAGE,profitMessage);
    }

    public void printError(ModelAndViewConverter modelAndViewConverter) {
        String errorMessage = modelAndViewConverter.getErrorMessage();
        System.out.println(ERROR_START_MESSAGE + errorMessage);
    }
}

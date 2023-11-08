package lotto.view;

import lotto.util.LottoResultData;
import lotto.util.ModelAndViewConverter;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String STATISTICS_NUMBER_OF_SAME = "%d개 일치";
    private static final String STATISTICS_PRIZE_AND_COUNT = " (%,d원) - %d개\n";
    private static final String STATISTICS_BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_MESSAGE = "총 수익률은 %,.1f%%입니다.";
    private static final String ERROR_START_MESSAGE = "[ERROR]";
    private final ModelAndViewConverter modelAndViewConverter;

    public OutputView(ModelAndViewConverter modelAndViewConverter) {
        this.modelAndViewConverter = modelAndViewConverter;
    }

    public void printTotalNumberOfLotto() {
        System.out.printf(NUMBER_OF_LOTTO_MESSAGE, modelAndViewConverter.getNumberOfLottoBundle());
    }

    public void printTotalLotto() {
        for (String lottoMessage : modelAndViewConverter.getLottoMessages()) {
            System.out.println(lottoMessage);
        }
    }

    public void printLottoResultsData() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        while(modelAndViewConverter.hasLottoResultsData()) {
            LottoResultData lottoResultsData = modelAndViewConverter.getLottoResultsData();
            int numberOfSame = lottoResultsData.getNumberOfSame();
            long prizeMoney = lottoResultsData.getPrizeMoney();
            int count = lottoResultsData.getCount();
            boolean isSecond = lottoResultsData.isSecond();
            String winningStatisticMessage = makeWinningStatisticsMessage(isSecond);
            System.out.printf(winningStatisticMessage, numberOfSame, prizeMoney, count);
        }
    }

    private String makeWinningStatisticsMessage(boolean isSecond) {
        String bonusBallMessage = getBonusBallMessage(isSecond);
        return STATISTICS_NUMBER_OF_SAME + bonusBallMessage + STATISTICS_PRIZE_AND_COUNT;
    }

    private String getBonusBallMessage(boolean isSecond) {
        if (isSecond) {
            return STATISTICS_BONUS_BALL_MATCH;
        }
        return "";
    }

    public void printProfit() {
        double profitMessage = modelAndViewConverter.getProfitMessage();
        System.out.printf(PROFIT_MESSAGE,profitMessage);
    }

    public void printError() {
        String errorMessage = modelAndViewConverter.getErrorMessage();
        System.out.println(ERROR_START_MESSAGE + errorMessage);
    }
}

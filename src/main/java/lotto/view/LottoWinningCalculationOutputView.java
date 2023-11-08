package lotto.view;

import lotto.domain.WinningStatistics;

public class LottoWinningCalculationOutputView {
    private final static String WINNING_STATISTICS = "당첨 통계\n---";
    private final static String OUTPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String OUTPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - ";
    private final static String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - ";
    private final static String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - ";
    private final static String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final static String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private final static String COUNT = "개";
    private final static String WINNING_RATE = "총 수익률은 ";
    private final static String END = "%입니다.";


    public void outputWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(FIFTH_PLACE_MESSAGE + winningStatistics.getFifthPlace() + COUNT);
        System.out.println(FOURTH_PLACE_MESSAGE + winningStatistics.getFourthPlace() + COUNT);
        System.out.println(THIRD_PLACE_MESSAGE + winningStatistics.getThirdPlace() + COUNT);
        System.out.println(SECOND_PLACE_MESSAGE + winningStatistics.getSecondPlace() + COUNT);
        System.out.println(FIRST_PLACE_MESSAGE + winningStatistics.getFirstPlace() + COUNT);
        outputWinningRate(winningStatistics);
    }

    public void outputWinningRate(WinningStatistics winningStatistics) {
        System.out.println(WINNING_RATE + winningStatistics.getWinningRate() + END);
    }

    public void outputWinningNumber() {
        System.out.println();
        System.out.println(OUTPUT_WINNING_NUMBER);
    }

    public void outputBonusNumber() {
        System.out.println();
        System.out.println(OUTPUT_BONUS_NUMBER);
    }
}


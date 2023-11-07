package lotto.view;

import lotto.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String PURCHASED_COUNT = "개를 구매했습니다.";
    private static final String _RESULT_TITLE = "당첨 통계";
    private static final String CONTOUR = "---";
    private static final String RESULT_THREE = "3개 일치 (5,000원) - ";
    private static final String RESULT_FOUR = "4개 일치 (50,000원) - ";
    private static final String RESULT_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String RESULT_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String RESULT_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT_UNIT = "개";
    private static final String RETURN_RATE = "총 수익률은 ";
    private static final String RETURN_RATE_SENTENCE = "%입니다.";

    private ConsoleOutputView() {
    }

    private static class OutputViewHolder {
        private static ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    }

    public static ConsoleOutputView getInstance() {
        return OutputViewHolder.consoleOutputView;
    }

    @Override
    public void printPurchasedCount() {
        System.out.println(PURCHASED_COUNT);
    }

    @Override
    public void printResultTitle() {
        System.out.println(_RESULT_TITLE);
    }

    @Override
    public void printContour() {
        System.out.println(CONTOUR);
    }

    @Override
    public void printResultThree() {
        System.out.println(RESULT_THREE);
    }

    @Override
    public void printResultFour() {
        System.out.println(RESULT_FOUR);
    }

    @Override
    public void printResultFive() {
        System.out.println(RESULT_FIVE);
    }

    @Override
    public void printResultFiveBonus() {
        System.out.println(RESULT_FIVE_BONUS);
    }

    @Override
    public void printResultSix() {
        System.out.println(RESULT_SIX);
    }

    @Override
    public void printCountUnit() {
        System.out.println(COUNT_UNIT);
    }

    @Override
    public void printReturnRate() {
        System.out.println(RETURN_RATE);
    }

    @Override
    public void printReturnRateSentence() {
        System.out.println(RETURN_RATE_SENTENCE);
    }
}

package lotto.view;

public class OutputView {
    static final String OUTPUT_PURCHASED_AMOUNT = "%d개를 구매했습니다.";
    static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";
    static final String OUTPUT_DIVISION_SLASH = "---";
    static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public void setOutputPurchasedAmount(int num) {
        System.out.printf(OUTPUT_PURCHASED_AMOUNT, num);
    }

    public void setOutputWinningStatistics() {
        System.out.println(OUTPUT_WINNING_STATISTICS);
    }

    public void setOutputDivisionSlash() {
        System.out.println(OUTPUT_DIVISION_SLASH);
    }

    public void setOutputRateOfReturn(double rate) {
        System.out.printf(OUTPUT_RATE_OF_RETURN, rate);
    }
}

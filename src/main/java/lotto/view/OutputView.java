package lotto.view;

import java.text.DecimalFormat;

public class OutputView {
    public void printStatsTitle() {
        System.out.println("당첨 통계\n---");
    }
    public void printStats(String description, int amount, int number) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(description + " (" + decimalFormat.format(amount) + "원) - " + number + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println("총 수익률은 " + decimalFormat.format(rateOfReturn) + "%입니다.");
    }
}

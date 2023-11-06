package lotto.view;

import java.text.DecimalFormat;

public class OutputView {
    public void printStatsTitle() {
        System.out.println("당첨 통계\n---");
    }
    public void printStats(String description, int amount, int number) {
        DecimalFormat decimalFormat = new DecimalFormat("###.###");
        String formattedAmount = decimalFormat.format(amount);
        System.out.println(description + " (" + formattedAmount + "원) - " + number + "개");
    }
}

package lotto.view;

public class PrintProfitRate {
    public static void printProfitRate(float profitRate) {
        String formattedProfitRate = String.format("%,.1f", profitRate);
        System.out.println("총 수익률은 " + formattedProfitRate + "%입니다.");
    }
}


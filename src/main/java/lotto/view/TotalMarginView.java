package lotto.view;

public class TotalMarginView {
    private static final String startMessage = "총 수익률은 ";
    private static final String endMessage = "%입니다.";

    public void printTotalMargin(double margin) {
        System.out.println(startMessage + String.format("%.1f", margin) + endMessage);
    }
}

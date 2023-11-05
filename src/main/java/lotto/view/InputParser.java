package lotto.view;

public class InputParser {
    // 구입금액 string > double (int 범위 넘어설 경우 대비)
    public double convertPurchaseAmount(String amount) {
        return Double.parseDouble(amount);
    }
}

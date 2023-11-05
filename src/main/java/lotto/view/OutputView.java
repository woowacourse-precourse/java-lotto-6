package lotto.view;

public class OutputView {
    public void printPurchaseResult(int lottoCount) {
        String result = String.format(OutputMessage.PURCHASE_RESULT.getMessage(), lottoCount);
        System.out.println(result);
    }
}

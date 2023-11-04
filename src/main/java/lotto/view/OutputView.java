package lotto.view;

public class OutputView {
    private static final String PURCAHSE_AMOUNT_FORMAT = "%d개를 구매했습니다.";

    public void printPurchaseAmount(int purchaseAmount){
        System.out.printf(PURCAHSE_AMOUNT_FORMAT,purchaseAmount);
    }
}

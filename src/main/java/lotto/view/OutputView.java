package lotto.view;

public class OutputView {

    private final static String PURCHASE_QUANTITY = "%d개를 구매했습니다.";

    public void printPurchaseQuantity(int quantity) {
        System.out.println(String.format(PURCHASE_QUANTITY, quantity));
    }

}

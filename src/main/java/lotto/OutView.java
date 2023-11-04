package lotto;

public class OutView {

    private final static String PURCHASE_QUANTITY = "%d개를 구매했습니다.";

    private void purchaseQuantity(int quantity) {
        System.out.println(String.format(PURCHASE_QUANTITY, quantity));
    }

}

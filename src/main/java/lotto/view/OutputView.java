package lotto.view;

public class OutputView {

    private final static String PRINT_BUY_AMOUNT = "%d개를 구매했습니다.\n";

    private void printBuyAmount(int buyAmount) {
        System.out.printf(PRINT_BUY_AMOUNT, buyAmount);
    }


}

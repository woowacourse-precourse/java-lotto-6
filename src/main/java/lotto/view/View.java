package lotto.view;

public class View {

    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "]";


    public void printRequestPriceMessage() {
        System.out.println(ViewMessage.REQUEST_PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public void printNumberOfPurchasedLotto(int number) {
        System.out.printf(ViewMessage.NUMBER_OF_PURCHASED_LOTTO_FORMAT.getMessage(), number);
        System.out.println();
    }


}

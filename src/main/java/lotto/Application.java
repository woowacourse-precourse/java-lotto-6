package lotto;

public class Application {
    public static Purchase getPurchaseAmount(GetPurchaseUI getPurchaseUI) {

        String input = getPurchaseUI.enterPurchaseAmountUI();

        return new Purchase(input);
    }

    public static void main(String[] args) {

        GetPurchaseUI getPurchaseUI = new GetPurchaseUI();
        Purchase purchase;

        while (true) {
            try {
                purchase = getPurchaseAmount(getPurchaseUI);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_PURCHASE_AMOUNT);
            }
        }

        System.out.println(purchase.getPurchaseAmount());
    }
}

package lotto.view;

import lotto.message.Message;

public class OutputView {
    private static void print(String message) {
        System.out.println(message);
    }

    public static void askPurchasingPrice() {
        print(Message.ASK_PURCHASING_PRICE.getMessage());
    }
}

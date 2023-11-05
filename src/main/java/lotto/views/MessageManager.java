package lotto.views;

import java.util.ResourceBundle;

public class MessageManager {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

    public static void getPurchaseAmountPromptMessage() {
        System.out.println(messages.getString("purchaseAmountPrompt.message"));
    }
}
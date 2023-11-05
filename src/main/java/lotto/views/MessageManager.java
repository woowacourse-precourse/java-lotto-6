package lotto.views;

import java.util.ResourceBundle;

public class MessageManager {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");
    private static final ResourceBundle exceptionMessages = ResourceBundle.getBundle("exception-messages");
    public static void getPurchaseAmountPromptMessage() {
        System.out.println(messages.getString("purchaseAmountPrompt.message"));
    }


    //Exception Messages
    public static String getValidateNonIntegerMessage() {
        return exceptionMessages.getString("validateNonInteger.message");
    }

}
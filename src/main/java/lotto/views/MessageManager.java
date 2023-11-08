package lotto.views;

import java.util.ResourceBundle;

public class MessageManager {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");
    private static final ResourceBundle exceptionMessages = ResourceBundle.getBundle("exception-messages");

    //General Messages
    public static void getPurchaseAmountPromptMessage() {
        System.out.println(messages.getString("purchaseAmountPrompt.message"));
    }

    public static void getProgramClosePromoptMessage() {
        System.err.println(messages.getString("programClosePromopt.message"));
    }

    public static void getLottoNumberPromptMessage() {
        System.out.println(messages.getString("lottoNumberPrompt.message"));
    }

    public static void getBonusNumberPromptMessage() {
        System.out.println(messages.getString("bonusNumberPrompt.message"));
    }

    public static void getWinnersCountPromptMessage() {
        System.out.println(messages.getString("winnersCountPrompt.message"));
    }

    public static void getHyphenPromptPromptMessage() {
        System.out.println(messages.getString("hyphenPrompt.message"));
    }

    //Exception Messages
    public static String getValidateNonIntegerMessage() {
        return exceptionMessages.getString("validateNonInteger.message");
    }

    public static String getValidateDivisibleByThousandMessage() {
        return exceptionMessages.getString("validateDivisibleByThousand.message");
    }

    public static String getCommaSeparatorMissingMessage() {
        return exceptionMessages.getString("commaSeparatorMissing.message");
    }

    public static String getDuplicateNumberMessage() {
        return exceptionMessages.getString("duplicateNumber.message");
    }

    public static String getWinningNumberInOneToFortyFiveMessage() {
        return exceptionMessages.getString("winningNumberInOneToFortyFive.message");
    }

    public static String getBonusNumberInOneToFortyFiveMessage() {
        return exceptionMessages.getString("bonusNumberInOneToFortyFive.message");
    }

    public static String getDuplicateBonusNumberAndWinningNumberMessage() {
        return exceptionMessages.getString("duplicateBonusNumberAndWinningNumber.message");
    }
}
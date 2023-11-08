package lotto;

import util.InputUtil;

import static validate.InputValidation.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getInputToPurchaseAmount();

    }

    private static int getInputToPurchaseAmount() {
        int purchaseAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = InputUtil.getUserInput("구입금액을 입력해 주세요.\n");
                purchaseAmount = validateAndGetPurchaseAmount(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static int validateAndGetPurchaseAmount(String input) {
        validateNumericInput(input);
        return Integer.parseInt(input);
    }


}

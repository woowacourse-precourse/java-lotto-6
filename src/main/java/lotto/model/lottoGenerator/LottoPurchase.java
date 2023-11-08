package lotto.model.lottoGenerator;

import lotto.controller.inputController.LottoPurchaseController;
import lotto.view.inputView.LottoPurchaseInput;

import static lotto.constant.ErrorMessages.*;


public class LottoPurchase {

    private final LottoPurchaseController purchaseController;

    public LottoPurchase(LottoPurchaseController purchaseController) {
        this.purchaseController = purchaseController;
    }
    public LottoPurchase() {
        this.purchaseController = new LottoPurchaseController(new LottoPurchaseInput());
    }

    public int getValidatedPurchaseAmount() {
        try {
            String input = purchaseController.requestPurchaseAmount();
            return validatePurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    private static int validatePurchaseAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
        int parsedAmount = parseInputToInt(input);
        validatePositiveAmount(parsedAmount);
        validateMultipleOfThousand(parsedAmount);

        return parsedAmount;
    }


    private static int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED);
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(AMOUNT_GREATER_THAN_ZERO);
        }
    }

    private static void validateMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_MULTIPLE_OF_THOUSAND);
        }
    }

}

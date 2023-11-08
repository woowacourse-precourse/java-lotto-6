package lotto.model.lottoGenerator;

import lotto.controller.inputController.LottoPurchaseController;
import lotto.view.inputView.LottoPurchaseInput;


public class LottoPurchase {

    private final LottoPurchaseController purchaseController;

    public LottoPurchase() {
        this.purchaseController = new LottoPurchaseController(new LottoPurchaseInput());
    }

    public int getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = purchaseController.requestPurchaseAmount();
                return validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validatePurchaseAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다. 다시 입력해주세요.");
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
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0원보다 커야 합니다. 다시 입력해주세요.");
        }
    }

    private static void validateMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위로 입력해야 합니다. 다시 입력해주세요.");
        }
    }

}

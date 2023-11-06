package lotto;

public class Player {
    private PlayerLotto lottos;
    private final int purchaseAmount;

    private Player(PlayerLotto lottos, int purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }

    public static Player initialize() {
        int purchaseAmount = initializePurchaseAmount();
        validateRange(purchaseAmount);

        return new Player(new PlayerLotto(), purchaseAmount);
    }

    private static int initializePurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = PromptHandler.inputPurchaseAmount();
                validateRange(purchaseAmount);
                validateUnit(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LottoConfig.PURCHASING_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
        }
    }

    private static void validateRange(int purchaseAmount) {
        if (purchaseAmount < LottoConfig.PURCHASING_UNIT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
        }
    }
}

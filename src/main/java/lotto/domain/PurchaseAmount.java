package lotto.domain;

public class PurchaseAmount {

    private final int purchaseAmount;

    private PurchaseAmount(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    public static PurchaseAmount from(String purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        validatePurchaseAmountNotNumber(purchaseAmount);
        validatePurchaseAmountUnderThousand(Integer.parseInt(purchaseAmount));
        validatePurchaseAmountDivideByThousand(Integer.parseInt(purchaseAmount));
    }

    private void validatePurchaseAmountDivideByThousand(int purchaseAmount) {
        if(purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private void validatePurchaseAmountNotNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 정수입니다.");
        }
    }

    private void validatePurchaseAmountUnderThousand(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000 이상의 정수입니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}

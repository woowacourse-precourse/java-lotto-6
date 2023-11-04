package lotto.domain;

public class PurchaseAmount {

    public void validate(String purchaseAmount) {
        validateAmountNotNumber(purchaseAmount);
        validateAmountUnderThousand(Integer.parseInt(purchaseAmount));
        validateDivideByThousand(Integer.parseInt(purchaseAmount));
    }

    public void validateDivideByThousand(int purchaseAmount) {
        if(purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public void validateAmountNotNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 정수입니다.");
        }
    }

    public void validateAmountUnderThousand(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000 이상의 정수입니다.");
        }
    }
}

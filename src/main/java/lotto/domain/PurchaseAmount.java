package lotto.domain;

public class PurchaseAmount {

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
}

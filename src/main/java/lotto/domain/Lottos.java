package lotto.domain;

public class Lottos {
    int numberOfLottos;

    public Lottos(String purchaseAmount) {
        numberOfLottos = validatePurchaseAmount(purchaseAmount);
    }

    private int validatePurchaseAmount(String purchaseAmount) {
        validateNumber(purchaseAmount);
        return validateDivisibilityByLottoPrice(purchaseAmount);
    }

    private void validateNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int validateDivisibilityByLottoPrice(String purchaseAmount) {
        int purchaseResult = Integer.parseInt(purchaseAmount);
        if(purchaseResult % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseResult % 1000;
    }
}

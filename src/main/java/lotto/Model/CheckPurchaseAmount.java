package lotto.Model;

public class CheckPurchaseAmount {

    public int getNumberOfTicket(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfTicket = purchaseAmount / 1000;

        return numberOfTicket;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

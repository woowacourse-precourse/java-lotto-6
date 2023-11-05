package lotto.cashier;

public class Cashier {

    private ReceivedAmount receivedAmount;

    public int calculateLottoCount(int purchaseAmount) {
        receivedAmount = ReceivedAmount.create(purchaseAmount);
        return purchaseAmount / 1000;
    }

}

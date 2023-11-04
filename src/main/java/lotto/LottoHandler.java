package lotto;

public class LottoHandler {
    private static final int LOTTO_PRICE = 1000;

    public int calculateLottoTicketCount(String receivedPurchasePrice) {
        int purchasePrice = Integer.parseInt(receivedPurchasePrice);
        return purchasePrice / LOTTO_PRICE;
    }
}

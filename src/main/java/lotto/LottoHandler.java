package lotto;

public class LottoHandler {
    private static final int LOTTO_PRICE = 1000;

    public int calculateLottoTicketCount(String receivedPurchasePrice) {
        int purchasePrice = Integer.parseInt(receivedPurchasePrice);
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력해 주세요.");
        }
        return purchasePrice / LOTTO_PRICE;
    }
}

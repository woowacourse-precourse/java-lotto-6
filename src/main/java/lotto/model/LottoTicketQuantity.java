package lotto.model;

public class LottoTicketQuantity {

    public int lottoTicketQuantity;
    private static final int LOTTO_PRICE = 1000;

    public int LottoTicketQuantity(int purchaseAmount) {
        this.lottoTicketQuantity = calculateLottoTicketQuantity(purchaseAmount);
        return lottoTicketQuantity;
    }

    private int calculateLottoTicketQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

}

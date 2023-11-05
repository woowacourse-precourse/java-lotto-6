package lotto.model;

public class LottoTicketQuantity {

    public int lottoTicketQuantity;
    private static final int LOTTO_PRICE = 1000;
    private static final String THOUSANDS_ERROR_MESSAGE = "[ERROR] 천원 단위로 입력해주세요.";

    public int LottoTicketQuantity(int purchaseAmount) {
        nonDivisibleAmount(purchaseAmount);
        this.lottoTicketQuantity = calculateLottoTicketQuantity(purchaseAmount);
        return lottoTicketQuantity;
    }

    private int calculateLottoTicketQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void nonDivisibleAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(THOUSANDS_ERROR_MESSAGE);
        }
    }

}

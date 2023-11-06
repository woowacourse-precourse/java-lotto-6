package lotto.service;

public class LottoService {

    private static final int LOTTO_TICKET_PRICE = 1000;

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        return amount / LOTTO_TICKET_PRICE;
    }
}
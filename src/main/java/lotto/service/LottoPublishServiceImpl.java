package lotto.service;

import lotto.domain.Amount;

public class LottoPublishServiceImpl implements LottoPublishService {

    private final Amount amount;

    public LottoPublishServiceImpl() {
        this.amount = new Amount();
    }

    @Override
    public void publish(int purchaseAmount) {
        int lottoTicketCount = calculateLottoTicketCount(purchaseAmount);
    }

    private int calculateLottoTicketCount(int purchaseAmount) {
        return amount.calculateTotalLottoCount(purchaseAmount);
    }
}

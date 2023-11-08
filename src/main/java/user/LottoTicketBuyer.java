package user;

import lottomachine.LottoAmountCalculator;

public class LottoTicketBuyer {
    public int LottoTicketAmount(int money) {
        LottoAmountCalculator lottoAmountCalculator = new LottoAmountCalculator();
        return lottoAmountCalculator.getLottoAmount(money);
    }
}

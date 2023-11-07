package user;

import lottomachine.LottoAmountCalculator;

public class LottoTicketBuyer {
    public int LottoTicketAmout(int money){
        LottoAmountCalculator lottoAmountCalculator = new LottoAmountCalculator();
        return lottoAmountCalculator.getLottoAmount(money);
    }
}

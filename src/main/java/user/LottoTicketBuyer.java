package user;

import lottomachine.CalculatorLottoAmount;

public class LottoTicketBuyer {
    public int LottoTicketAmout(int money){
        CalculatorLottoAmount calculatorLottoAmount = new CalculatorLottoAmount();
        return calculatorLottoAmount.getLottoAmount(money);
    }
}

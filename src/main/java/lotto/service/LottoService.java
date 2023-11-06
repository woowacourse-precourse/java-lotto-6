package lotto.service;

import lotto.view.InputView;

public class LottoService {
    
    InputView inputView = new InputView();

    public int getLotteryTicketCount() {
        return inputView.inputPurchasePrice() / 1000;
    }

    public void issueLotteryTicket() {

    }

    public void getMatchingNumbers() {

    }

    public void getRateOfReturn() {

    }
}

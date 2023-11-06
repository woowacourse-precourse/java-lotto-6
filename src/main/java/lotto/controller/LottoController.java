package lotto.controller;

import lotto.domain.Seller;
import lotto.view.DepositInput;
import lotto.view.LottoOutPut;

public class LottoController {
    public void lotto() {
        LottoOutPut.depositMessage();

        Seller seller = seller();
        LottoOutPut.lottoTicketsCountMessage(seller.getLottoTickets());

    }

    private Seller seller() {
        int deposit = DepositInput.deposit();
        return new Seller(deposit);
    }
}

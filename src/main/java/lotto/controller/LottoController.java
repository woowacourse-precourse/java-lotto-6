package lotto.controller;

import lotto.domain.LottoTickets;

public class LottoController {

    public static  void createBuyLottoTickets(long purchaseAmount){
        LottoTickets.createBuyLottoTickets(purchaseAmount);
    }
}

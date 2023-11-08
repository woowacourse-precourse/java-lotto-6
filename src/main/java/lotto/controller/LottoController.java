package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoController {
    public LottoController() {
    }

    private static class LottoControllerHolder{
        private static final LottoController lottoController = new LottoController();
    }

    public static LottoController getInstance(){
        return LottoControllerHolder.lottoController;
    }

    public  void buyLottoTickets(long purchaseAmount){
        LottoTickets.buyLottoTickets(purchaseAmount);
    }

    public  int getBuyLottoTicketsNum(){
        return LottoTickets.getBuyLottoTickets().size();
    }

    public  List<Lotto> getBuyLottoTickets(){
        return LottoTickets.getBuyLottoTickets();
    }



}

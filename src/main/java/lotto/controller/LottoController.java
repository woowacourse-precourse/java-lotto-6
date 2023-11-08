package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoController {

    private final  LottoTickets lottoTickets = LottoTickets.getInstance();
    private LottoController() {
    }

    private static class LottoControllerHolder{
        private static final LottoController lottoController = new LottoController();
    }

    public static LottoController getInstance(){
        return LottoControllerHolder.lottoController;
    }

    public void buyLottoTickets(long purchaseAmount){
        lottoTickets.buyLottoTickets(purchaseAmount);
    }

    public int getBuyLottoTicketsNum(){
        return lottoTickets.getBuyLottoTickets().size();
    }

    public List<Lotto> getBuyLottoTickets(){
        return lottoTickets.getBuyLottoTickets();
    }



}

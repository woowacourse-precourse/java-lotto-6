package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoController {

    public static  void buyLottoTickets(long purchaseAmount){
        LottoTickets.buyLottoTickets(purchaseAmount);
    }

    public static int getBuyLottoTicketsNum(){
        return LottoTickets.getBuyLottoTicketsNum();
    }

    public static List<Lotto> getBuyLottoTickets(){
        return LottoTickets.getBuyLottoTickets();
    }



}

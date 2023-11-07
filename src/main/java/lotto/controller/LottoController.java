package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class LottoController {

    public static  void buyLottoTickets(long purchaseAmount){
        LottoTickets.buyLottoTickets(purchaseAmount);
    }

    public static  void putWinningNums(String winningNums){
        WinningNumber.putWinningNum(winningNums);
    }
    public static void putBonusNum(String bonusNum){
        WinningNumber.putBonusNum(bonusNum);

    }
}

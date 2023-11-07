package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;

public class LottoCompareController {




    public static void lottoTicketsCompareNum(){
        for(Lotto lotto : LottoTickets.getBuyLottoTickets()){
            lottoCompareNum(lotto);
        }

    }

    private static void lottoCompareNum(Lotto lotto){
        int mathNum = 0;
        boolean bonusNum = false;
        for(Integer lottoNum : lotto.getNumbers()){
            if(WinningNumber.getWinningNums().contains(lottoNum)){
                mathNum++;
            }
            if(WinningNumber.getBonusNum() == lottoNum){
                bonusNum = true;
            }
        }
        increaseWinningDetails(mathNum,bonusNum);
    }
    private static void increaseWinningDetails(int mathNum, boolean bonusNum){
        if(mathNum == 3){
            WinningLotto.increaseTreeSameNumLotto();
        }
        if(mathNum == 4){
            WinningLotto.increaseFourSameNumLotto();
        }
        if(mathNum == 5){
            if(bonusNum == false){
                WinningLotto.increaseFiveSameNumLotto();
            }
            if(bonusNum == true){
                WinningLotto.increaseFiveAndBonusSameNumLotto();
            }
        }
        if(mathNum == 6){
            WinningLotto.increaseSixSameNumLotto();
        }
    }

}

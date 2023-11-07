package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumber;
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
            WinningLottoNumber.increaseTreeSameNumLotto();
        }
        if(mathNum == 4){
            WinningLottoNumber.increaseFourSameNumLotto();
        }
        if(mathNum == 5){
            if(bonusNum == false){
                WinningLottoNumber.increaseFiveSameNumLotto();
            }
            if(bonusNum == true){
                WinningLottoNumber.increaseFiveAndBonusSameNumLotto();
            }
        }
        if(mathNum == 6){
            WinningLottoNumber.increaseSixSameNumLotto();
        }
    }

}

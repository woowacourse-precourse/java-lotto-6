package lotto.controller;

import lotto.domain.*;

public class LottoCompareController {




    public static void lottoTicketsCompareNum(){
        for(Lotto lotto : LottoTickets.getBuyLottoTickets()){
            lottoCompareNum(lotto);
        }

    }

    public static double winningLottoRate(){
        double purchaseAmount = LottoTickets.getBuyLottoTicketsNum() * 1000;
        double winningMoney =  winningMoney();
        double resultRate = winningMoney/purchaseAmount * 100;
        return Math.round(resultRate*100)/100.0;
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

    private static long winningMoney(){

        return WinningMoney.FIRST.getWinningMoney() * WinningLotto.getSixSameNumLotto()
                + WinningMoney.SECOND.getWinningMoney() * WinningLotto.getFiveAndBonusSameNumLotto()
                + WinningMoney.THIRD.getWinningMoney() * WinningLotto.getFiveSameNumLotto()
                + WinningMoney.FOURTH.getWinningMoney() * WinningLotto.getFourSameNumLotto()
                + WinningMoney.FIFTH.getWinningMoney() * WinningLotto.getTreeSameNumLotto();

    }

}

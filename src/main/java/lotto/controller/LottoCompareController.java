package lotto.controller;

import lotto.domain.*;

public class LottoCompareController {


    public LottoCompareController() {
    }

    private static class LottoCompareControllerHolder{
        private static final LottoCompareController lottoCompareController = new LottoCompareController();
    }

    public static LottoCompareController getInstance(){
        return LottoCompareControllerHolder.lottoCompareController;
    }
    public  void lottoTicketsCompareNum(){
        WinningLotto.WinningLottoInit();
        for(Lotto lotto : LottoTickets.getBuyLottoTickets()){
            lottoCompareNum(lotto);
        }

    }

    public  double winningLottoRate(){
        double purchaseAmount = LottoTickets.getBuyLottoTickets().size() * 1000;
        double winningMoney =  winningMoney();
        double resultRate = winningMoney/purchaseAmount * 100;
        return Math.round(resultRate*100)/100.0;
    }

    private  void lottoCompareNum(Lotto lotto){
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
    private void increaseWinningDetails(int mathNum, boolean bonusNum){
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

    private  long winningMoney(){

        return WinningMoney.FIRST.getWinningMoney() * WinningLotto.getSixSameNumLotto()
                + WinningMoney.SECOND.getWinningMoney() * WinningLotto.getFiveAndBonusSameNumLotto()
                + WinningMoney.THIRD.getWinningMoney() * WinningLotto.getFiveSameNumLotto()
                + WinningMoney.FOURTH.getWinningMoney() * WinningLotto.getFourSameNumLotto()
                + WinningMoney.FIFTH.getWinningMoney() * WinningLotto.getTreeSameNumLotto();

    }

}

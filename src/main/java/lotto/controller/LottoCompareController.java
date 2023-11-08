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
        WinningLotto.getInstance().WinningLottoInit();
        for(Lotto lotto : LottoTickets.getInstance().getBuyLottoTickets()){
            lottoCompareNum(lotto);
        }

    }

    public  double winningLottoRate(){
        double purchaseAmount = LottoTickets.getInstance().getBuyLottoTickets().size() * 1000;
        double winningMoney =  winningMoney();
        double resultRate = winningMoney/purchaseAmount * 100;
        return Math.round(resultRate*100)/100.0;
    }

    private  void lottoCompareNum(Lotto lotto){
        int mathNum = 0;
        boolean bonusNum = false;
        for(Integer lottoNum : lotto.getNumbers()){
            if(WinningNumber.getInstance().getWinningNums().contains(lottoNum)){
                mathNum++;
            }
            if(WinningNumber.getInstance().getBonusNum() == lottoNum){
                bonusNum = true;
            }
        }
        increaseWinningDetails(mathNum,bonusNum);
    }
    private void increaseWinningDetails(int mathNum, boolean bonusNum){
        if(mathNum == 3){
            WinningLotto.getInstance().increaseTreeSameNumLotto();
        }
        if(mathNum == 4){
            WinningLotto.getInstance().increaseFourSameNumLotto();
        }
        if(mathNum == 5){
            if(!bonusNum){
                WinningLotto.getInstance().increaseFiveSameNumLotto();
            }
            if(bonusNum){
                WinningLotto.getInstance().increaseFiveAndBonusSameNumLotto();
            }
        }
        if(mathNum == 6){
            WinningLotto.getInstance().increaseSixSameNumLotto();
        }
    }

    private  long winningMoney(){

        return WinningMoney.FIRST.getWinningMoney() * WinningLotto.getInstance().getSixSameNumLotto()
                + WinningMoney.SECOND.getWinningMoney() * WinningLotto.getInstance().getFiveAndBonusSameNumLotto()
                + WinningMoney.THIRD.getWinningMoney() * WinningLotto.getInstance().getFiveSameNumLotto()
                + WinningMoney.FOURTH.getWinningMoney() * WinningLotto.getInstance().getFourSameNumLotto()
                + WinningMoney.FIFTH.getWinningMoney() * WinningLotto.getInstance().getTreeSameNumLotto();

    }

}

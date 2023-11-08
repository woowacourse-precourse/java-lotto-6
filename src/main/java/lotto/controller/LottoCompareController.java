package lotto.controller;

import lotto.domain.*;

public class LottoCompareController {

    private final WinningLotto winningLotto = WinningLotto.getInstance();
    private final WinningNumber winningNumber = WinningNumber.getInstance();
    private final LottoTickets lottoTickets = LottoTickets.getInstance();

    private LottoCompareController() {
    }

    private static class LottoCompareControllerHolder{
        private static final LottoCompareController lottoCompareController = new LottoCompareController();
    }

    public static LottoCompareController getInstance(){
        return LottoCompareControllerHolder.lottoCompareController;
    }
    public  void lottoTicketsCompareNum(){
        winningLotto.WinningLottoInit();
        for(Lotto lotto : lottoTickets.getBuyLottoTickets()){
            lottoCompareNum(lotto);
        }

    }

    public  double winningLottoRate(){
        double purchaseAmount = lottoTickets.getBuyLottoTickets().size() * 1000;
        double winningMoney =  winningMoney();
        double resultRate = winningMoney/purchaseAmount * 100;
        return Math.round(resultRate*100)/100.0;
    }

    private  void lottoCompareNum(Lotto lotto){
        int mathNum = 0;
        boolean bonusNum = false;
        for(Integer lottoNum : lotto.getNumbers()){
            if(winningNumber.getWinningNums().contains(lottoNum)){
                mathNum++;
            }
            if(winningNumber.getBonusNum() == lottoNum){
                bonusNum = true;
            }
        }
        increaseWinningDetails(mathNum,bonusNum);
    }
    private void increaseWinningDetails(int mathNum, boolean bonusNum){
        if(mathNum == 3){
            winningLotto.increaseTreeSameNumLotto();
        }
        if(mathNum == 4){
            winningLotto.increaseFourSameNumLotto();
        }
        if(mathNum == 5){
            if(!bonusNum){
                winningLotto.increaseFiveSameNumLotto();
            }
            if(bonusNum){
                winningLotto.increaseFiveAndBonusSameNumLotto();
            }
        }
        if(mathNum == 6){
            winningLotto.increaseSixSameNumLotto();
        }
    }

    private  long winningMoney(){

        return WinningMoney.FIRST.getWinningMoney() * winningLotto.getSixSameNumLotto()
                + WinningMoney.SECOND.getWinningMoney() * winningLotto.getFiveAndBonusSameNumLotto()
                + WinningMoney.THIRD.getWinningMoney() * winningLotto.getFiveSameNumLotto()
                + WinningMoney.FOURTH.getWinningMoney() * winningLotto.getFourSameNumLotto()
                + WinningMoney.FIFTH.getWinningMoney() * winningLotto.getTreeSameNumLotto();

    }

}

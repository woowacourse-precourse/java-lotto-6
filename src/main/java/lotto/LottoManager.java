package lotto;

import java.util.List;

public class LottoManager {

    LottoGame lottoGame;
    Input input;
    Output output;
    List<Lotto> lottoList;
    int howManyLottos;
    List<Integer> winningNumbers;
    int bonusNumber;
    int payMoney;

    public LottoManager(){
        input=new Input();
        output=new Output();
        lottoGame=new LottoGame();
    }

    public void getHowMuchLotto(){
        output.instructInputMoney();
        payMoney=input.getInput();
        howManyLottos=payMoney/1000;
        output.showLottoPurchaseCount(howManyLottos);
    }

    public void createLotto(){
        lottoGame.setPayMoney(payMoney);
        lottoList=lottoGame.generateLottos(howManyLottos);
        output.showPurchaseLottoNumber(lottoList);
    }

    public void getWinning(){
        // 당첨 번호
        output.instructInputWinningNumbers();
        winningNumbers=input.getWinningNumber();
        output.instructInputBonusNumber();
        bonusNumber=input.getBonusNumber(winningNumbers);
    }

    public void getResult(){
        lottoGame.checkWinningCombination(lottoList,winningNumbers,bonusNumber);
        int[] result= lottoGame.getPrizeCount();
        output.showStats(result);
        output.showRateOfReturn(lottoGame.getStats());
    }

    public void startLotto(){

        getHowMuchLotto();
        createLotto();
        getWinning();
        getResult();
    }

}

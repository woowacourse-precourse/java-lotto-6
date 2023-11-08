package lotto.controller;

import lotto.model.LottoCompare;
import lotto.model.LottoMaker;
import lotto.model.LottoResult;
import lotto.model.Ratio;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private int money;
    private LottoMaker lottoMaker;
    private LottoCompare lottoCompare;
    private LottoResult lottoResult;
    private Ratio ratio;

    public LottoController(){
        lottoCompare = new LottoCompare();
        lottoResult = new LottoResult();
    }

    public void run(){
        errorRestart(this::setLottoMaker);
        errorRestart(this::setLottoCompareWinning);
        errorRestart(this::setLottoCompareBonus);
        setLottoResult();
        setRatio();
    }

    private void errorRestart(Runnable runnable){
        while(true){
            try{
                runnable.run();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void setLottoMaker() throws IllegalArgumentException{
        Output.printMoney();
        money = Input.moneyInput();
        lottoMaker = new LottoMaker(money);
        Output.printBuylotto(money);
        Output.printlottos(lottoMaker);
    }

    private void setLottoCompareWinning() throws IllegalArgumentException{
        Output.printWinning();
        lottoCompare.setWinningNumbers(Input.winnigInput());
        Output.printGap();
    }

    private void setLottoCompareBonus() throws IllegalArgumentException{
        Output.printBonus();
        lottoCompare.setBonusNumber(Input.bonusInput());
        Output.printGap();
    }

    private void setLottoResult(){
        lottoResult.addLottos(lottoMaker,lottoCompare);
        Output.printEnd();
        Output.printResults(lottoResult);
    }

    private void setRatio(){
        ratio = new Ratio(money,lottoResult);
        Output.printRatio(ratio);
    }

}

package lotto.controller;

import java.util.List;
import lotto.domain.Lottos;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private int money;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public void run(){
        money=Input.getMoney();
        Lottos lottos = buyLottos();

        winningNumber = Input.getWinningNumber();
        bonusNumber = Input.getBonusNumber(winningNumber);

        int[] lottoResult = lottos.getLottoResults(winningNumber, bonusNumber);
        Output.ShowResult(lottoResult);
        Output.ShowProfit(lottoResult, money);
    }

    private void getInputs(){

    }
    private Lottos buyLottos(){
        int lottoAmount = (int) (money/1000);
        Lottos lottos = new Lottos(lottoAmount);
        Output.ShowLottos(lottos);
        return lottos;
    }

}

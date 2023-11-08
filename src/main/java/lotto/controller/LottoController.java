package lotto.controller;

import java.util.List;
import lotto.domain.Lottos;
import lotto.view.Input;

public class LottoController {
    private int money;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public void run(){
        getInputs();
        Lottos lottos = buyLottos();

    }

    private void getInputs(){
        money=Input.getMoney();
        winningNumber = Input.getWinningNumber();
        bonusNumber = Input.getBonusNumber(winningNumber);
    }
    private Lottos buyLottos(){
        int lottoAmount = (int) (money/1000);
        return new Lottos(lottoAmount);
    }
}

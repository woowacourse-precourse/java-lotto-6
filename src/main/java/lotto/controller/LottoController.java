package lotto.controller;

import java.util.List;
import lotto.domain.*;
import lotto.domain.generator.LottoGenerator;

import lotto.view.InputMoneySpentOnLottoView;
import lotto.view.InputWinningNumbersView;
import lotto.view.InputBonusNumberView;

import static lotto.view.OutputNumberOfBoughtLottoView.printBoughtLottos;
import static lotto.view.OutputLottoNumbersView.printLottos;
import static lotto.view.OutputLottoResultsView.printResults;

public class LottoController {

    public void start(){
        User lotto = getMoney();
        printBoughtLottos(lotto);

        Lottos lottos = new Lottos(getLottos(lotto.getNumberOfLotto()));
        printLottos(lottos);

        WinningLotto win = getWinningLotto();
        printResults(win);

    }

    public User getMoney(){
        InputMoneySpentOnLottoView spentMoney = new InputMoneySpentOnLottoView();
        int money = spentMoney.getValue();

        return new User(money);
    }

    public List<Lotto> getLottos(int numOfLotto){
        LottoGenerator lottoMaker = new LottoGenerator();
        return lottoMaker.FullLottoMaker(numOfLotto);
    }

    public WinningLotto getWinningLotto() {
        InputWinningNumbersView winningNumber = new InputWinningNumbersView();
        List<Integer> win = winningNumber.getValue();

        return new WinningLotto(win, getBonusLotto());
    }

    public int getBonusLotto() {
        InputBonusNumberView bonusNumber = new InputBonusNumberView();
        int bonus = bonusNumber.getValue();

        return bonus;
    }
}

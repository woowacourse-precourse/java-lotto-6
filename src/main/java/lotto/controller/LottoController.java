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
import static lotto.view.OutputReturnRateView.printReturnRate;

public class LottoController {

    public void start(){
        User lotto = getMoney();
        printBoughtLottos(lotto);

        Lottos lottos = new Lottos(getLottos(lotto.getNumberOfLotto()));
        printLottos(lottos);

        WinningLotto win = getWinningLotto();
        win = getBonusLotto(win);
        Compare scoreResult = new Compare();
        scoringResult(scoreResult, win, lottos);

        printResults(scoreResult);
        ReturnRate rate = getReturnRate(scoreResult, lotto);
        printReturnRate(rate);

    }

    public User getMoney(){
        while(true) {
            try {
                InputMoneySpentOnLottoView spentMoney = new InputMoneySpentOnLottoView();
                int money = spentMoney.getValue();
                User user = new User(money);
                return user;
            } catch(IllegalArgumentException e) {
            }
        }

    }

    public List<Lotto> getLottos(int numOfLotto){
        LottoGenerator lottoMaker = new LottoGenerator();
        return lottoMaker.FullLottoMaker(numOfLotto);
    }

    public WinningLotto getWinningLotto() {
        while(true) {
            try {
                InputWinningNumbersView winningNumber = new InputWinningNumbersView();
                List<Integer> win = winningNumber.getValue();
                WinningLotto winningLotto = new WinningLotto(win);
                return winningLotto;
            } catch (IllegalArgumentException e){
            }
        }
    }

    public WinningLotto getBonusLotto(WinningLotto win) {
        while(true) {
            try{
                InputBonusNumberView bonusNumber = new InputBonusNumberView();
                int bonus = bonusNumber.getValue();
                win.setBonusNumber(bonus);
                return win;
            }catch (IllegalArgumentException e){
            }
        }
    }

    public void scoringResult(Compare score, WinningLotto win, Lottos lottos) {
        score.scoringResult(win, lottos);
    }

    public ReturnRate getReturnRate(Compare scoreResult, User user) {
        return new ReturnRate(scoreResult, user);
    }
}

package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        int inputMoney = InputView.getInputMoney();
        List<Lotto> boughtLotto = LottoMachine.buy(inputMoney);
        int count = LottoMachine.getLottoCount(inputMoney);
        OutputView.printPurchasedLottos(boughtLotto, count);

        WinningLotto winningLotto = getWinningLotto();
        List<Ranking> rankings = getRanks(boughtLotto, winningLotto);

        System.out.println("run에서 getRanks후: "+rankings);
        OutputView.printLottoResult(inputMoney, rankings);
    }

    public WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.getWinningNumber();
        Lotto lotto = new Lotto(winningNumbers);
//        Lotto lotto = new Lotto(InputView.getWinningNumber());
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        // return new WinningLotto(lotto, bonusNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    public List<Ranking> getRanks(List<Lotto> boughtLotto, WinningLotto winningLotto) {
        List<Ranking> ranks = new ArrayList<>();

        for (Lotto lotto : boughtLotto) {
            Ranking ranking = Ranking.calculate(lotto, winningLotto);
            ranks.add(ranking);
        }
        return ranks;
    }
}

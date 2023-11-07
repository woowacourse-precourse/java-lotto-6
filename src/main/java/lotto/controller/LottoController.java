package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;


public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = askMoney();
        int count = money.getCount();
        Lottos lottos = buyLottos(count);
        printBuyResult(lottos, count);
        WinningNumbers winningNumbers = makeWinningNumbers();
        LottoResult lottoResult = winningNumbers.checkLottos(lottos);
        Arrays.stream(Rank.values()).forEach(rank->outputView.printLottosResult(rank, lottoResult.getResult(rank)));

    }

    private Money askMoney() {
        Money money = new Money(inputView.requestMoney());
        outputView.printLottoCount(money.getCount());
        return money;
    }

    private Lottos buyLottos(int count) {
        Lottos lottos = new Lottos();
        lottos.generateLottos(count);
        return lottos;
    }

    private void printBuyResult(Lottos lottos, int count){
        outputView.printLottoCount(count);
        lottos.getLottos().forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private WinningNumbers makeWinningNumbers() {
        Lotto lotto;
        int bonusNum;
        try{
            lotto = new Lotto(inputView.requestWinningNumbers());
        }catch (IllegalArgumentException e) {
            lotto = new Lotto(inputView.requestWinningNumbers());
        }
        bonusNum = inputView.requestBonusNumber();
        try {
            return new WinningNumbers(lotto, bonusNum);
        } catch (IllegalArgumentException e){
            bonusNum = inputView.requestBonusNumber();
            return new WinningNumbers(lotto, bonusNum);
        }
    }

}

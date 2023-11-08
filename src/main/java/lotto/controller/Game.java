package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public Game(LottoMachine lottoMachine, InputView inputView, OutputView outputView) {
        this.lottoMachine = lottoMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int price = inputView.requestPurchaseAmount();

        List<Lotto> lottos = lottoMachine.buy(price);

        outputView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.requestWinningNumbers();
        int bonusNumber = inputView.requestBonusNumber();

        WinningNumber winningNumber = WinningNumber.of(winningNumbers, BonusNumber.of(bonusNumber));
    }
}

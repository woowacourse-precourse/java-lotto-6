package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.Referee;
import lotto.domain.WinningLotto;
import lotto.utils.Parser;
import lotto.utils.io.InputManager;
import lotto.utils.io.OutputManager;

import java.util.List;

public class Controller {
    private static final int CURRENCY = 1000;

    private Lottos lottos;
    private WinningLotto winningLotto;
    private int lottoCount;

    public void run() {
        int purchasePrice = InputManager.receivePurchasePrice();
        List<Integer> winningNumbers = InputManager.receiveNumbers();
        int bonusNumber = InputManager.receiveBonusNumber(winningNumbers);

        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        lottoCount = purchasePrice / CURRENCY;
        lottos = new Lottos(lottoCount);

        OutputManager.printLottos(lottoCount, lottos);
        OutputManager.printResult(Referee.judgePrize(lottos, winningLotto), purchasePrice);

        Console.close();
    }
}

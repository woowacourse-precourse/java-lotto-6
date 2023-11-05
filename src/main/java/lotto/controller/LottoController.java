package lotto.controller;

import static lotto.view.OutputView.printLottoList;
import static lotto.view.OutputView.printLottoQuantity;

import java.util.List;
import lotto.domain.GenerateLotto;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }
    public void play() {
        Money money = inputView.inputMoney();
        printLottoQuantity(money);

        GenerateLotto generateLotto = new GenerateLotto();
        int count = money.getLottoQuantity();
        List<Lotto> lotto = generateLotto.getLottoNumbers(count);

        Lottos lottos = new Lottos(lotto);
        printLottoList(lottos);

        List<Integer> winningNumbers = inputView.inputLottoWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);

        int bonusNumber = inputView.inputBonusNumber();




    }
}

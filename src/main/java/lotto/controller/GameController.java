package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Pay;
import lotto.util.Generator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Pay pay;
    private List<Lotto> userLottos;
    private Lotto winningNumber;
    private BonusNumber bonusNumber;

    public void run() {
        buyLotto();
        generateWinningNumber();
    }

    private void buyLotto() {
        pay = new Pay(inputView.requestPayment());
        userLottos = generateLottos();
        printLottos(userLottos);
    }

    private List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < pay.getLottoAmounts(); i++) {
            lottos.add(new Lotto(Generator.generateRandomNumbers()));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printAmmountLotto(lottos.size());
        for (Lotto lotto : lottos) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void generateWinningNumber() {
        winningNumber = new Lotto(inputView.requestWinningNumber());
        bonusNumber = new BonusNumber(inputView.requestBonusNumber());
    }
}

package lotto.controller;

import static lotto.view.OutputView.printLottoList;
import static lotto.view.OutputView.printLottoQuantity;
import static lotto.view.OutputView.printRate;
import static lotto.view.OutputView.printResult;

import java.util.List;
import java.util.Map;
import lotto.domain.GenerateLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoResult lottoResult;
    public LottoController(InputView inputView, LottoResult lottoResult) {
        this.inputView = inputView;
        this.lottoResult = lottoResult;
    }
    public void play() {
        Money money = getUserMoney();
        Lottos lottos = generateUserLottos(money);
        printLottoList(lottos);

        Lotto winningLotto = getUserWinningLotto();
        int bonusNumber = getUserBonusNumber(winningLotto);

        Map<Rank, Integer> result = getUserResults(lottos, winningLotto, bonusNumber);
        printResult(result);
        printRate(result, money);
    }

    private Money getUserMoney() {
        while (true) {
            try {
                inputView.printPurchaseAmount();
                Money money = inputView.inputMoney();
                printLottoQuantity(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos generateUserLottos(Money money) {
        GenerateLotto generateLotto = new GenerateLotto();
        int count = money.getLottoQuantity();
        return new Lottos(generateLotto.getLottoNumbers(count));
    }

    private Lotto getUserWinningLotto() {
        while (true) {
            try {
                inputView.printWinningNumbers();
                List<Integer> winningNumbers = inputView.inputLottoWinningNumbers();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getUserBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                inputView.printBonusNumber();
                return inputView.inputBonusNumber(winningLotto.getNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Rank, Integer> getUserResults(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        return lottoResult.compareLotto(lottos, winningLotto, bonusNumber);
    }


}

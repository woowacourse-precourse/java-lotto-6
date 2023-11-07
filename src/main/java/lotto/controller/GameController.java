package lotto.controller;

import java.util.Map;
import java.util.function.Supplier;
import lotto.InputException;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private static final String DUPLICATE_ERROR_MESSAGE = "당첨 번호와 중복되지 않는 번호를 입력해주세요.";

    public void run() {
        Money money = initMoney();
        Lottos lottos = initLottos();
        buyLottos(lottos, money);

        Lotto winningLotto = initWinningLotto();
        BonusNumber bonusNumber = initBonusNumber(winningLotto);

        Map<Integer, Integer> resultOfLottos = lottos.countNumberOfWins(winningLotto, bonusNumber);
        displayStatistics(resultOfLottos, money.getProfitRate(resultOfLottos));
    }

    private Money initMoney() {
        return wrapByLoop(() -> new Money(InputView.getPurchaseCost()));
    }

    private Lottos initLottos() {
        return wrapByLoop(() -> new Lottos(new RandomNumbers()));
    }

    private void buyLottos(Lottos lottos, Money money) {
        generateLottos(lottos, money.getDividedBy1000());
        displayLottos(lottos);
    }

    private void generateLottos(Lottos lottos, int count) {
        lottos.generate(count);
    }

    private void displayLottos(Lottos lottos) {
        OutputView.printLottos(lottos.getOrderedList());
    }

    private Lotto initWinningLotto() {
        return wrapByLoop(() -> new Lotto(InputView.getWinningNumbers()));
    }

    private BonusNumber initBonusNumber(Lotto winningLotto) {
        return wrapByLoop(() -> {
            int number = InputView.getBonusNumber();
            validateDulpicate(winningLotto, number);

            return new BonusNumber(number);
        });
    }

    private void displayStatistics(Map<Integer, Integer> resultOfLottos, double profitRate) {
        OutputView.printWinningStatistics(resultOfLottos, profitRate);
    }

    private void validateDulpicate(Lotto winningLotto, int number) {
        if (winningLotto.isAleadyIn(number)) {
            throw new InputException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private <T> T wrapByLoop(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (InputException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

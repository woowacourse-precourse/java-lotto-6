package lotto.controller;

import lotto.domain.*;
import lotto.service.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.configuration.Constants.*;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getLottoCount());
        Lotto winningLotto = getWinningLotto();
        Bonus bonus = getBonus(winningLotto);
        Result result = getResult(winningLotto, lottos, bonus);
        createRate(money.getMoney(), result.getReward());
    }

    private Money getMoney() {
        while (true) {
            try {
                String input = inputView.readString(Message.NEED_PURCHASE_MONEY);
                int money = numberGenerator.createOne(input);

                return new Money(money);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private Lottos getLottos(int lottoCount) {
        List<List<Integer>> randomNumberLists = numberGenerator.createRandomNumberLists(lottoCount);
        Lottos lottos = new Lottos(randomNumberLists);
        outputView.printLottos(lottos);

        return lottos;
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                String input = inputView.readString(Message.ENTER_WINNING_LOTTO);
                List<Integer> winningNumbers = numberGenerator.createNumbers(input);

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private Bonus getBonus(Lotto winningLotto) {
        while (true) {
            try {
                String input = inputView.readString(Message.NEED_BONUS_NUMBER);
                int bonus = numberGenerator.createOne(input);

                return new Bonus(bonus, winningLotto);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private Result getResult(Lotto winningLotto, Lottos lottos, Bonus bonus) {
        Result result = new Result(winningLotto, lottos, bonus);
        outputView.printResult(result);
        return result;
    }

    private void createRate(int purchaseMoney, int reward) {
        Rate rate = new Rate(purchaseMoney, reward);
        outputView.printRate(rate);
    }

}


package lotto.controller;

import lotto.domain.*;
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
        getRate(money.getMoney(), result.getReward());
    }

    private Money getMoney() {
        while (true) {
            try {
                outputView.println(Message.NEED_PURCHASE_MONEY);
                String input = inputView.readOne();
                int money = numberGenerator.createOne(input);

                return new Money(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos getLottos(int lottoCount) {
        List<List<Integer>> randomNumberLists = numberGenerator.createRandomNumberLists(lottoCount);
        Lottos lottos = new Lottos(randomNumberLists);
        outputView.println(lottos);
        return lottos;
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                outputView.println(Message.ENTER_WINNING_LOTTO);
                String input = inputView.readOne();
                List<Integer> winningNumbers = numberGenerator.createNumbers(input);

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Bonus getBonus(Lotto winningLotto) {
        while (true) {
            try {
                outputView.println(Message.NEED_BONUS_NUMBER);
                String input = inputView.readOne();
                int bonus = numberGenerator.createOne(input);

                return new Bonus(bonus, winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Result getResult(Lotto winningLotto, Lottos lottos, Bonus bonus) {
        Result result = new Result(winningLotto, lottos, bonus);
        outputView.println(result);
        return result;
    }

    private void getRate(int purchaseMoney, int reward) {
        Rate rate = new Rate(purchaseMoney, reward);
        outputView.println(rate);
    }

}


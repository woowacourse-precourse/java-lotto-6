package lotto.controller;

import lotto.model.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.random.Number.LottoGenerator;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;


public class StateController {

    private Money money;
    private Lottos lottos;
    private Lotto answerLotto;
    private Bonus bonus;

    public void run() {
        enterMoney();
        purchaseLotto();
        enterAnswer();
        enterBonus();
        calculateResult();
    }

    private void enterMoney() {
        try {
            money = new Money(Integer.parseInt(readMoney().trim()));
        } catch (IllegalArgumentException exception) {
            printException(exception.getMessage());
            enterMoney();
        }
    }

    private void purchaseLotto() {
        lottos = new Lottos(IntStream
                .range(0, money.lottoCount())
                .mapToObj(i -> new Lotto(LottoGenerator()))
                .toList());
        printLottoCount(money.lottoCount());

        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.getNumbers());
        }
    }

    private void enterAnswer() {
        List<Integer> answerLotto = Stream
                .of(readAnswer().trim().split(","))
                .map(Integer::parseInt)
                .toList();

        try {
            this.answerLotto = new Lotto(answerLotto);
        } catch (IllegalArgumentException exception) {
            printException(exception.getMessage());
            enterAnswer();
        }
    }

    private void enterBonus() {
        try {
            this.bonus = new Bonus(Integer.parseInt(readBonus().trim()), answerLotto.getNumbers());
        } catch (IllegalArgumentException exception) {
            printException(exception.getMessage());
            enterBonus();
        }
    }

    private void calculateResult() {
        Map<Price, Integer> scores = lottos.calculateScore(answerLotto, bonus);
        printResult();
        for (Map.Entry<Price, Integer> score : scores.entrySet()) {
            printPrice(score.getKey().getGuideline()
                    , NumberFormat.getInstance().format(score.getKey().getReward())
                    , score.getValue());
        }
        printProfit(lottos.calculateProfit(scores, money.getMoney()));
    }
}

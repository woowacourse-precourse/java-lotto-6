package lotto.controller;

import lotto.model.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.model.RandomNumber.LottoGenerator;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;


public class LottoController {

    private Purchase purchase;
    private PlayLotto playLotto;
    private Lotto answerLotto;
    private BonusNumber bonusNumber;

    public void run() {
        giveMoney();
        purchaseLotto();
        inputAnswer();
        inputBonus();
        calculateResult();
    }

    private void giveMoney() {
        try {
            purchase = new Purchase(readMoney().trim());
        } catch (IllegalArgumentException exception) {
            printException(exception.getMessage());
            giveMoney();
        }
    }


    private void purchaseLotto() {
        int numberOfLottosToPurchase = purchase.countLottos();
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottosToPurchase; i++) {
            Lotto lotto = new Lotto(LottoGenerator());
            purchasedLottos.add(lotto);
        }

        playLotto = new PlayLotto(purchasedLottos);
        printLottoCount(numberOfLottosToPurchase);

        for (Lotto lotto : purchasedLottos) {
            printLotto(lotto.getNumbers());
        }
    }


    private void inputAnswer() {
        List<Integer> answerLotto = Stream
                .of(readAnswer().trim().split(","))
                .map(Integer::parseInt)
                .toList();
        try {
            this.answerLotto = new Lotto(answerLotto);
        } catch (IllegalArgumentException exception) {
            printException(exception.getMessage());
            inputAnswer();
        }
    }


    private void inputBonus() {
        try {
            this.bonusNumber = new BonusNumber(readBonus().trim(), answerLotto.getNumbers());
        } catch (IllegalArgumentException exception) {
            printException(exception.getMessage());
            inputBonus();
        }
    }

    private void calculateResult() {
        Map<Price, Integer> scores = playLotto.calculateScore(answerLotto, bonusNumber);
        printResult();
        for (Map.Entry<Price, Integer> score : scores.entrySet()) {
            printPrice(
                    score.getKey().printStr(),
                    NumberFormat.getInstance().format(score.getKey().getReward()),
                    score.getValue()
            );
        }
        printProfit(playLotto.calculateProfit(scores, purchase.getLottos()));
    }

}
package lotto.controller;

import lotto.NumberGenerator;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.configuration.Constants.*;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    private final NumberGenerator numberGenerator;

    private final MoneyController moneyController;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator, MoneyController moneyController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.moneyController = moneyController;
    }

    public void play() {
        Money money = getMoney();
    }

    private Money getMoney() {
        while (true) {
            try {
                outputView.println(Message.NEED_PURCHASE_MONEY);
                String input = inputView.readOne();
                int money = numberGenerator.createOne(input);
                return moneyController.create(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

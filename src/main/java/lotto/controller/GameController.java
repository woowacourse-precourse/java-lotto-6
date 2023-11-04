package lotto.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.constant.GameConstant;
import lotto.domain.Lotto;
import lotto.util.RandomNumberGenerator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    RandomNumberGenerator generator = new RandomNumberGenerator();
    public void play() {
        int payment = getPayment();
        buy(payment/GameConstant.PAYMENT_UNIT);
        inputView.getNumbers();

    }

    private int getPayment() {
        try {
            return validator.validate(inputView.getPayment());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return getPayment();
        }
    }
    public void buy(int count){
        outputView.printBuyMessage(count);
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = generator.generateRandomNumbers();
            Collections.sort(lotto);
            new Lotto(lotto);
            outputView.printLottos(lotto);
        }
    }
}

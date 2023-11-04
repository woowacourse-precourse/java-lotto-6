package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.GameConstant;
import lotto.domain.Lotto;
import lotto.dto.LottosResponse;
import lotto.util.RandomNumberGenerator;
import lotto.util.Validator;
import lotto.view.InputView;

public class GameController {
    InputView inputView = new InputView();
    Validator validator = new Validator();
    RandomNumberGenerator generator = new RandomNumberGenerator();
    public void play() {
        int payment = getPayment();
        LottosResponse response = buy(payment/GameConstant.PAYMENT_UNIT);

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
    public LottosResponse buy(int count){
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = generator.generateRandomNumbers();
            Collections.sort(lotto);
            new Lotto(lotto);
            lottos.add(lotto);
        }
        return new LottosResponse(lottos);
    }
}

package lotto.controller;

import lotto.model.Validator;
import lotto.view.Message;

public class Game {
    private final Integer LOTTO_PRICE = 1000;

    private final Message message;
    private final Validator validator;

    public Game() {
        this.message = new Message();
        this.validator = new Validator();
    }

    public void start() {
        Integer lottoCount = buyLotto();
    }

    private Integer buyLotto() {
        Integer lottoCount;
        String cost = message.inputCost();

        validator.validateCost(cost);
        lottoCount = countLotto(cost);
        message.printLottoCount(lottoCount);
        return lottoCount;
    }

    private Integer countLotto(String cost) {
        return (Integer.parseInt(cost) / LOTTO_PRICE);
    }
}

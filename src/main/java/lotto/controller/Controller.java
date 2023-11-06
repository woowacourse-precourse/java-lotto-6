package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.view.View;
import lotto.view.constant.Message;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.constant.Message.OUTPUT_BUY;

public class Controller {

    private final static View view = new View();
    public void start() {
        view.output(Message.INPUT_COST);
        Buyer buyer = getCost();

        int count = buyer.getBuyCount();
        view.output(String.format(OUTPUT_BUY, count));

        List<Lotto> lottos = generateLottos(count);
        for (Lotto lotto : lottos) {
            view.output(lotto.toString());
        }
    }

    private Buyer getCost() {
        try {
            int cost = view.inputCost();
            return new Buyer(cost);
        } catch (IllegalArgumentException e) {
            view.output(e.getMessage());
            return getCost();
        }
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Lotto.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

}

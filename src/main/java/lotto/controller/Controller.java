package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.View;
import lotto.view.constant.Message;

public class Controller {

    private final static View view = new View();
    public void start() {
        view.output(Message.INPUT_COST);
        Buyer buyer = getCost();
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
}

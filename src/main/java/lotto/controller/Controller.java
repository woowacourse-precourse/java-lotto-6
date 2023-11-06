package lotto.controller;

import lotto.domain.Buyer;
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

package lotto.controller;

import static lotto.SystemConstant.DEFAULT_DEPTH;
import static lotto.SystemConstant.LOTTO_PRICE;
import static lotto.controller.ViewController.request;
import static lotto.view.OutputView.printNumOfTickets;
import static lotto.view.SystemMessage.ASK_MONEY;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;


public class UnifiedController {
    private List<Lotto> lottos;
    private int numOfTickets;

    public UnifiedController() {
        this.lottos = new ArrayList<>();
        this.numOfTickets = 0;
    }

    public void start() {
        String input = request(ASK_MONEY, DEFAULT_DEPTH);
        this.numOfTickets = calcNumOfTickets(input);
        printNumOfTickets(this.numOfTickets);
    }

    public int calcNumOfTickets(String input) {
        int money = Integer.parseInt(input);
        return money / LOTTO_PRICE;
    }
}

package lotto.controller;

import static lotto.SystemConstant.DEFAULT_DEPTH;
import static lotto.controller.ViewController.request;
import static lotto.view.SystemMessage.ASK_MONEY;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;


public class UnifiedController {
    private List<Lotto> lottos;

    public UnifiedController() {
        this.lottos = new ArrayList<>();
    }

    public void start() {
        String input = request(ASK_MONEY, DEFAULT_DEPTH);
    }
}

package lotto.controller;

import lotto.model.Lotto;
import lotto.view.View;

import java.util.ArrayList;

public class LottoGameController {
    static ArrayList<ArrayList<Integer>> lottos;
;
    public LottoGameController () {
        View.printStartMessage();
    }

    public void lottoGameFlow() {
        View.inputTotalCost();
        View.printNumberOfLotto();
        View.printlottos();
    }
}

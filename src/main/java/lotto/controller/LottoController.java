package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView lottoView;

    public LottoController() {
        this.lottoView = new LottoView();
    }

    public int inputPurchaseMoney() {
        lottoView.printPurchasePrompt();
        int purchaseMoney = Integer.parseInt(Console.readLine());
        return purchaseMoney;
    }
}

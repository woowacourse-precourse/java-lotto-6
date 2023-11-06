package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ChangeMoneyToLotto;
import lotto.domain.CreateLotto;

public class PurchaseResultController {

    private static final String PURCHASE_OUTPUT_RESULT = "%d개를 구매했습니다.\n";
    ChangeMoneyToLotto changeMoneyToLotto = new ChangeMoneyToLotto();
    WinningNumberController winningNumberController = new WinningNumberController();
    CreateLotto createLotto = new CreateLotto();
    List<List<Integer>> createsLotto = new ArrayList<>();

    public void start(String purchaseAmount) {
        int lottoCounts = changeMoneyToLotto.changeMoneyToLotto(purchaseAmount);
        System.out.printf(PURCHASE_OUTPUT_RESULT, lottoCounts);
        createsLotto = createLotto.createLotto(lottoCounts);
        System.out.println("createsLotto = " + createsLotto);
        winningNumberController.start();
    }

}

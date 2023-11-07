package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ChangeMoneyToLotto;
import lotto.domain.CreateLotto;

public class PurchaseResultController {

    private static final String PURCHASE_OUTPUT_RESULT = "%d개를 구매했습니다.\n";
    private static final ChangeMoneyToLotto changeMoneyToLotto = new ChangeMoneyToLotto();
    private static final WinningNumberController winningNumberController = new WinningNumberController();
    private static final CreateLotto createLotto = new CreateLotto();
    public static List<List<Integer>> createsLotto = new ArrayList<>();

    public void start(String purchaseAmount) {
        int lottoCounts = changeMoneyToLotto.changeMoneyToLotto(purchaseAmount);
        System.out.printf(PURCHASE_OUTPUT_RESULT, lottoCounts);
        createsLotto = createLotto.createLotto(lottoCounts);
        winningNumberController.start();
    }

}

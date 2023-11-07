package lotto.view;

import static lotto.enums.OutputMessage.*;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class OutputView {
    public void promptForPurchaseAmount() {
        System.out.println(PURCHASE_ACCOUNT_PROMPT.getMessage());
    }

    public void displayPurchaseAmount(int count) {
        System.out.printf(PURCHASE_NUMBER_OUTPUT.getMessage(), count);
    }

    public void displayPurchaseLotto(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public void promptForWinningNumbers() {
        System.out.println(WINNING_NUMBER_PROMPT.getMessage());
    }

    public void promptForBonusNumbers() {
        System.out.println(BONUS_NUMBER_PROMPT.getMessage());
    }

    public void displayResult(Map<String, Integer> lottoResults, double profit) {
        //TODO 구현
        System.out.println(WINNING_STATISTICS_OUTPUT.getMessage());
    }
}

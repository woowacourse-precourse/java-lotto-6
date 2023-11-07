package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class OutPutView {
    private final int WINNING_NUMBER_3 = 3;
    private final int WINNING_NUMBER_6 = 6;

    public void displayMessage(ViewPrompt viewPrompt) {
        System.out.println(viewPrompt.getMessage());
    }

    public void printPurchasedLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount + ViewPrompt.PURCHASE_MESSAGE.getMessage());
    }

    public void printGeneratedLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printOutputStartMessage() {
        System.out.println(ViewPrompt.OUTPUT_START_MESSAGE.getMessage());
        System.out.println(ViewPrompt.LINE.getMessage());
    }

    public void printWinningCountResult(Map<String, Integer> winningResults) {
        System.out.printf(WinningType.WINNING_COUNT_3.getMessage() + "%d개%n", winningResults.get("3"));
        System.out.printf(WinningType.WINNING_COUNT_4.getMessage() + "%d개%n", winningResults.get("4"));
        System.out.printf(WinningType.WINNING_COUNT_5.getMessage() + "%d개%n", winningResults.get("5"));
        System.out.printf(WinningType.WINNING_COUNT_5_AND_BONUS.getMessage() + "%d개%n", winningResults.get("5_bonus"));
        System.out.printf(WinningType.WINNING_COUNT_6.getMessage() + "%d개%n", winningResults.get("6"));
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다. %n ", yield);
    }

}

package lotto.view;

import static lotto.enums.OutputMessage.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoRank;
import lotto.model.Lotto;

public class OutputView {
    public void promptForPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT.getMessage());
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

    public void displayResult(Map<LottoRank, Integer> lottoResult, double profit) {
        System.out.println(WINNING_STATISTICS_OUTPUT.getMessage());
        for (LottoRank rank : LottoRank.values()) {
            int count = lottoResult.get(rank);
            System.out.println(rank.getRankDescription() + " - " + count + "개");
        }

        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

    public void displayArgumentError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void displayNumberFormatError(NumberFormatException e) {
        System.out.println(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
    }
}

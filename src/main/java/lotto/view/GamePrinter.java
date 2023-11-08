package lotto.view;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.MarginCalculator;
import lotto.model.domain.constants.LottoGameConstants;
import lotto.model.domain.constants.LottoGameMessage;

public class GamePrinter {

    public void printInputPurchaseAmount() {
        System.out.println(LottoGameMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printPurchaseCount(int count) {
        System.out.println(LottoGameMessage.PURCHASE_COUNT.format(count));
    }

    public void printAmountLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printInputLottoNumbers() {
        System.out.println(LottoGameMessage.LOTTO_NUMBERS.getMessage());
    }

    public void printInputBonusNumber() {
        System.out.println(LottoGameMessage.BONUS_NUMBER.getMessage());
    }

    public void printWinningStats() {
        System.out.println(LottoGameMessage.WINNING_STATS.getMessage());
    }

    public void printMatchStats(int match, int prize, int count) {
        if (match > LottoGameConstants.NUMBERS_PER_LOTTO.getValue()) {
            match -= LottoGameConstants.BONUS_COUNT.getValue();
        }
        System.out.println(LottoGameMessage.MATCH_COUNT.format(match, prize, count));
    }

    public void printMatchBonusStats(int match, int prize, int count) {
        match -= LottoGameConstants.BONUS_COUNT.getValue();
        System.out.println(LottoGameMessage.MATCH_BONUS_COUNT.format(match, prize, count));
    }

    public void printTotalProfitRate(MarginCalculator marginCalculator) {
        System.out.println(LottoGameMessage.TOTAL_PROFIT_RATE.format(marginCalculator.getMargin()));
    }
}

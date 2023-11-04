package lotto.view;

import static lotto.constant.LottoResult.*;
import static lotto.constant.message.OutputMessage.*;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import lotto.constant.LottoResult;
import lotto.constant.message.OutputMessage;
import lotto.domain.LottoResultCount;

public class OutputView {
    public void printPurchaseAmount(int amount) {
        System.out.println(amount+PURCHASE_LOTTO.getMessage());
    }

    public void printPurchaseLotto(List<Integer> lotto) {
        String formattedLotto = listToString(lotto);
        System.out.println(formattedLotto);
    }

    public String listToString(List<Integer> list) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int number : list) {
            joiner.add(Integer.toString(number));
        }
        return joiner.toString();
    }

    public void outputWinningResult(LottoResultCount lottoResultCount){
        System.out.println(OutputMessage.RESULT_START);
        winningResultOutput(lottoResultCount);
    }

    public void winningResultOutput(LottoResultCount lottoResultCount){
        printWinningResult(THREE_COUNT.getPrizeCount(), THREE_COUNT.getPrizeMoney(), lottoResultCount.getThreeCount());
        printWinningResult(FOUR_COUNT.getPrizeCount(), FOUR_COUNT.getPrizeMoney(), lottoResultCount.getFourCount());
        printWinningResult(FIVE_COUNT.getPrizeCount(), FIVE_COUNT.getPrizeMoney(), lottoResultCount.getFiveCount());
        printWinningResult(FIVE_COUNT_WITH_BONUS.getPrizeCount(), FIVE_COUNT_WITH_BONUS.getPrizeMoney(), lottoResultCount.getFiveWithBonusCount());
        printWinningResult(SIX_COUNT.getPrizeCount(), SIX_COUNT.getPrizeMoney(), lottoResultCount.getSixCount());
    }
    public void printWinningResult(int number, int price, int matchCount) {
        String priceWithComma = String.format("%,d", price);
        if (number == FIVE_COUNT_WITH_BONUS.getPrizeCount()) {
            System.out.printf(RESULT_BONUS.getMessage(), priceWithComma, matchCount);
            return;
        }
        System.out.printf(RESULT_LOTTO.getMessage(), number, priceWithComma, matchCount);
    }

}

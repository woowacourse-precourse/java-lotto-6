package lotto.view;

import static lotto.constant.LottoResult.*;
import static lotto.constant.message.OutputMessage.*;

import java.util.List;
import java.util.StringJoiner;
import lotto.constant.message.OutputMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoResultCount;

public class OutputView {

    public void printAboutPurchase(int amount, List<Lotto> purchaseLotto) {
        printPurchaseAmount(amount);
        printPurchaseLotto(purchaseLotto);
    }

    private void printPurchaseAmount(int amount) {
        System.out.println("\n" + amount + PURCHASE_LOTTO.getMessage());
    }

    private void printPurchaseLotto(List<Lotto> purchaseLotto) {
        for (Lotto lotto :
                purchaseLotto) {
            printPurchaseLottoNumber(lotto.getLottoNumbers());
        }
    }

    private void printPurchaseLottoNumber(List<Integer> lotto) {
        List<Integer> sortedLotto = lotto.stream()
                .sorted()
                .toList();
        String formattedLotto = listToString(sortedLotto);
        System.out.println(formattedLotto);
    }

    private String listToString(List<Integer> list) {
        StringJoiner joiner = new StringJoiner(DELIMITER.getMessage(), PREFIX.getMessage(), SUFFIX.getMessage());
        for (int number : list) {
            joiner.add(Integer.toString(number));
        }
        return joiner.toString();
    }

    public void outputWinningResult(LottoResultCount lottoResultCount, double rate) {
        System.out.println(OutputMessage.RESULT_START.getMessage());
        winningResultOutput(lottoResultCount);
        System.out.printf(PROFIT_RATE.getMessage(), rate);
    }

    private void winningResultOutput(LottoResultCount lottoResultCount) {
        printWinningResult(THREE_COUNT.getPrizeCount(), THREE_COUNT.getPrizeMoney(), lottoResultCount.getThreeCount());
        printWinningResult(FOUR_COUNT.getPrizeCount(), FOUR_COUNT.getPrizeMoney(), lottoResultCount.getFourCount());
        printWinningResult(FIVE_COUNT.getPrizeCount(), FIVE_COUNT.getPrizeMoney(), lottoResultCount.getFiveCount());
        printWinningResult(FIVE_COUNT_WITH_BONUS.getPrizeCount(), FIVE_COUNT_WITH_BONUS.getPrizeMoney(),
                lottoResultCount.getFiveWithBonusCount());
        printWinningResult(SIX_COUNT.getPrizeCount(), SIX_COUNT.getPrizeMoney(), lottoResultCount.getSixCount());
    }

    private void printWinningResult(int number, int price, int matchCount) {
        String priceWithComma = String.format("%,d", price);
        if (number == FIVE_COUNT_WITH_BONUS.getPrizeCount()) {
            System.out.printf(RESULT_BONUS.getMessage(), priceWithComma, matchCount);
            return;
        }
        System.out.printf(RESULT_LOTTO.getMessage(), number, priceWithComma, matchCount);
    }

}

package lotto.domain;

import lotto.Lotto;
import lotto.util.MessageUtil;

import java.util.List;
import java.util.function.Predicate;



public class LottoPrize {

    private final MessageUtil messageUtil = new MessageUtil();

    private final LottoResult lottoResult = new LottoResult();

    private final LottoWinningNumber winningNumInfo;

    public LottoPrize(LottoWinningNumber lottoWinningNumber) {
        this.winningNumInfo = lottoWinningNumber;
    }

    public void getLottoStats(List<Lotto> userLottos, int purchaseAmount) {
        messageUtil.printWinningStats();

        for (Lotto userLotto : userLottos) {
            List<Integer> userLottoNums = userLotto.getLottoNumbers();
            int matchCount = getMatchCount(userLottoNums);
            addMatchCount(checkBonusNumber(userLottoNums, matchCount));
        }

    }

    private void addMatchCount(int matchCount) {
        if (matchCount == THREE_COUNT.getNumber()) {
            lottoResult.addThreeCount();
        }
        if (matchCount == FOUR_COUNT.getNumber()) {
            lottoResult.addFourCount();
        }
        if (matchCount == FIVE_COUNT.getNumber()) {
            lottoResult.addFiveCount();
        }
        if (matchCount == FIVE_COUNT_WITH_BONUS.getNumber()) {
            lottoResult.addFiveWithBonusCount();
        }
        if (matchCount == SIX_COUNT.getNumber()) {
            lottoResult.addSixCount();
        }
    }

    private int checkBonusNumber(List<Integer> userNums, int matchCount) {
        if (matchCount == FIVE_COUNT.getNumber() && userNums.contains(winningNumInfo.getBonusNum())) {
            return matchCount * 10;
        }

        return matchCount;
    }

    private String computeEarningRate(int purchaseAmount, long winningAmount) {
        if (winningAmount == 0) {
            return "0";
        }

        double earningRate = (double) winningAmount / (double) purchaseAmount * 100;
        return String.format("%.1f", earningRate);
    }
}
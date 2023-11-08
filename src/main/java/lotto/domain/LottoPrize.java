package lotto.domain;

import lotto.util.MessageUtil;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.function.Predicate;

import static lotto.constant.LottoPrice.*;

public class LottoPrize {
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoManage lottoManage = new LottoManage();
    private final WinningNumber winningNumInfo;

    public LottoPrize(WinningNumber winningNumber) {
        this.winningNumInfo = winningNumber;
    }

    public void getLottoStatistics(List<Lotto> userLottos, int purchaseAmount) {
        messageUtil.printWinningStatistics();

        for(Lotto userLotto : userLottos) {
            List<Integer> userLottoNums = userLotto.getLottoNumbers();
            int matchCount = getMatchCount(userLottoNums);
            addMatchCount(checkBonusNumber(userLottoNums, matchCount));
        }

        printResultStatistics(purchaseAmount);
    }

    private void printResultStatistics(int purchaseAmount) {
        messageUtil.printWinningResult(FIFTH.getNumber(), FIFTH.getPrice(), lottoManage.getFifth());
        messageUtil.printWinningResult(FOURTH.getNumber(), FOURTH.getPrice(), lottoManage.getFourth());
        messageUtil.printWinningResult(THIRD.getNumber(), THIRD.getPrice(), lottoManage.getThird());
        messageUtil.printWinningResult(SECOND.getNumber(), SECOND.getPrice(), lottoManage.getSecond());
        messageUtil.printWinningResult(FIRST.getNumber(), FIRST.getPrice(), lottoManage.getFirst());

        long totalWinningAmount = getTotalWinningAmount();
        double earningRate = Double.parseDouble(computeEarningRate(purchaseAmount, totalWinningAmount));

        messageUtil.printEarningRate(earningRate);
    }

    private long getTotalWinningAmount() {
        return (long) lottoManage.getFifth() * FIFTH.getPrice()
                + (long) lottoManage.getFourth() * FOURTH.getPrice()
                + (long) lottoManage.getThird() * THIRD.getPrice()
                + (long) lottoManage.getSecond() * SECOND.getPrice()
                + (long) lottoManage.getFirst() * FIRST.getPrice();
    }

    private void addMatchCount(int matchCount) {
        if (matchCount == FIFTH.getNumber()) {
            lottoManage.addFifth();
        }
        if (matchCount == FOURTH.getNumber()) {
            lottoManage.addFourth();
        }
        if (matchCount == THIRD.getNumber()) {
            lottoManage.addThird();
        }
        if (matchCount == SECOND.getNumber()) {
            lottoManage.addSecond();
        }
        if (matchCount == FIRST.getNumber()) {
            lottoManage.addFirst();
        }
    }

    private int getMatchCount(List<Integer> userNums) {
        return Long.valueOf(winningNumInfo.getWinningNums()
                .stream()
                .filter(lottoNum -> userNums.stream()
                        .anyMatch(Predicate.isEqual(lottoNum)))
                .count()).intValue();
    }

    private int checkBonusNumber(List<Integer> userNums, int matchCount) {
        if (matchCount == THIRD.getNumber() && userNums.contains(winningNumInfo.getBonusNum())) {
            return matchCount * 10;
        }
        return matchCount;
    }

    private String computeEarningRate(int purchaseAmount, long winningAmount) {
        if (winningAmount == 0) {
            return "0";
        }

        double earningRate = (double) winningAmount / (double) purchaseAmount * 100;
        return String.format("%,.1f", earningRate);
    }
}

package lotto.domain.proxy;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Paper;

import java.util.Objects;
import java.util.StringJoiner;

public class PrizeHandlerImpl implements PrizeHandler {
    private PrizeHandler nextPrizeHandler;
    private final int matchingNumbers;
    private final PrizeAmount prizeAmount;
    private final boolean isBonus;
    private final Count count;


    private PrizeHandlerImpl(int matchingNumbers, PrizeAmount prizeAmount, Count count, boolean isBonus) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
        this.count = count;
        this.isBonus = isBonus;
    }

    public static PrizeHandler of(int matchingNumbers, int prizeAmount, boolean isBonus) {
        return new PrizeHandlerImpl(matchingNumbers, PrizeAmount.of(prizeAmount), Count.of(0), isBonus);
    }


    @Override
    public void setNextPrizeHandler(PrizeHandler nextPrizeHandler) {
        this.nextPrizeHandler = nextPrizeHandler;
    }


    @Override
    public void process(Paper paper, Lotto lotto) {
        if (isNotMatched(Lottery.matchingCount(paper, lotto, isBonus)) && Objects.nonNull(nextPrizeHandler)) {
            nextPrizeHandler.process(paper, lotto);
        }
    }

    public int getTotalPrizeCount() {
        int getTotalPrizeCount = 0;
        if (Objects.nonNull(nextPrizeHandler)) {
            getTotalPrizeCount += nextPrizeHandler.getTotalPrizeCount();
        }
        if (count.getCount() > 0) {
             getTotalPrizeCount += count.getCount() * prizeAmount.getAmount();
        }
        return getTotalPrizeCount;
    }

    @Override
    public double earnRate(int investedAmount) {
        double profitPercentage = ((double) getTotalPrizeCount() / investedAmount) * 100; // 수익률 계산

        return Math.round(profitPercentage * 100.0) / 100.0;
    }

    @Override
    public String printWinningStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        if (Objects.nonNull(nextPrizeHandler)) {
            String winningStatistics = nextPrizeHandler.printWinningStatistics();
            stringBuilder.append(winningStatistics);
        }
        return stringBuilder.append(this).toString();
    }

    private boolean isNotMatched(int matchedCount) {
        if (matchedCount == matchingNumbers) {
            count.increment();
            return false;
        }
        return true;
    }

    /**
     * 각 당첨번호별 당첨 횟수를 출력
     * ex) 1등일 경우 - 1개만 일치
     * 6개 일치 (2,000,000,000원) - 1개
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        if (isBonus){
            stringJoiner.add(matchingNumbers + "개 일치, 보너스 볼 일치 (" + prizeAmount + "원) - " + count.getCount() + "개" + "\n");
            return stringJoiner.toString();
        }
        stringJoiner.add(matchingNumbers + "개 일치 (" + prizeAmount + "원) - " + count.getCount() + "개" + "\n");
        return stringJoiner.toString();
    }
}

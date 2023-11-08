package lotto.model;

import lotto.dto.PurchaseResult;
import lotto.type.WinningType;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    public static final int BONUS_WINNING_TYPE_INDEX = 3;

    private final List<Integer> winningNumbers;
    private final List<Lotto> lottos;
    private final List<Integer> statistic;
    private final int buyAmount;

    public Winning(List<Integer> winningNumbers, List<Lotto> lottos, int buyAmount) {
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
        this.statistic = new ArrayList<>();
        this.buyAmount = buyAmount;
        calculateStatistic();
    }

    private void calculateStatistic() {
        for (WinningType winningType : WinningType.values()) {
            statistic.add(countWinning(winningType));
        }
    }

    private int countWinning(WinningType winningType) {
        int count = 0;
        for (Lotto lotto : lottos) {
            if (lotto.countHit(winningNumbers) == winningType.getHit()) {
                count++;
            }
        }
        return count;
    }

    private void applyBonusNumber() {
        int winningCount = statistic.get(BONUS_WINNING_TYPE_INDEX);

        for (Lotto lotto : lottos) {
            if (lotto.isBonusHit(winningNumbers)) {
                winningCount--;
            }
        }

        statistic.set(BONUS_WINNING_TYPE_INDEX, winningCount);
    }

    public static Winning create(WinningNumbers winningNumbers, PurchaseResult purchaseResult) {
        return new Winning(winningNumbers.getNumbers(), purchaseResult.getLottos(), purchaseResult.getQuantity() * 1000);
    }

    public List<Integer> getStatistic() {
        return statistic;
    }

    public double getYields() {
        int moneyGet = 0;
        int index = 0;
        for (WinningType winningType : WinningType.values()) {
            moneyGet += winningType.getMoney() * statistic.get(index);
            index++;
        }
        return (double) moneyGet / buyAmount * 100;
    }

}

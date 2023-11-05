package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LotteryResult implements Comparator<LotteryResult> {

    FIRST(1, 6, 0, 2_000_000_000),
    SECOND(2, 5, 1, 30_000_000),
    THIRD(3, 5, 0, 1_500_000),
    FOURTH(4, 4, 0, 50_000),
    FIFTH(5, 3, 0, 5000);

    private final int priority;
    private final int count;
    private final int bonus;
    private final int money;

    LotteryResult(int prirority, int count, int bonus, int money) {
        this.priority = prirority
        this.count = count;
        this.bonus = bonus;
        this.money = money;
    }

    public static int getWinnerMoneyOf(int count, int bonus) throws IllegalStateException {
        LotteryResult lotteryResult = Arrays.stream(LotteryResult.values())
            .filter(result -> result.count == count && result.bonus == bonus)
            .findAny()
            .orElseThrow(() -> new IllegalStateException("존재하지 않는 당첨번호, 보너스 번호 갯수입니다."));
        return lotteryResult.money;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compare(LotteryResult o1, LotteryResult o2) {
        return o1.getPriority() - o2.getPriority();
    }
}

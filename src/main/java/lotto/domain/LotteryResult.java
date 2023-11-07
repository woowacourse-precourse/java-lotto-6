package lotto.domain;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public enum LotteryResult {

    FIRST(1, 6, 0, 2_000_000_000),
    SECOND(2, 5, 1, 30_000_000),
    THIRD(3, 5, 0, 1_500_000),
    FOURTH(4, 4, 0, 50_000),
    FIFTH(5, 3, 0, 5000),
    NOTHING(6, -1, -1, 0);

    private final int priority;
    private final int count;
    private final int bonus;
    private final int money;

    LotteryResult(int prirority, int count, int bonus, int money) {
        this.priority = prirority;
        this.count = count;
        this.bonus = bonus;
        this.money = money;
    }

    public static LotteryResult getWinnerMoneyOf(int count, int bonus) throws IllegalStateException {
        Optional<LotteryResult> lotteryResult = Arrays.stream(LotteryResult.values())
            .filter(result -> result.count == count && result.bonus == bonus)
            .findAny();

        if (!lotteryResult.isPresent()) {
            return NOTHING;
        }

        return lotteryResult.orElseThrow(
            () -> new IllegalStateException("존재하지 않는 결과입니다. 당첨번호, 보너스 번호 갯수를 다시 확인해주세요.")
        );
    }

    public int getLotteryMoney() {
        return money;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NumberFormat formatter = NumberFormat.getNumberInstance();

        sb.append(count + "개 일치");
        if (bonus != 0) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (" + formatter.format(money) + "원)");
        return sb.toString();
    }
}

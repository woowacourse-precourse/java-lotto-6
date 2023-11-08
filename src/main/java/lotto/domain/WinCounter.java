package lotto.domain;

import lotto.constant.Mark;
import lotto.constant.Value;
import lotto.constant.WinType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinCounter {
    private final Map<WinType, Integer> winCounts;
    private static final int ZERO = Value.ZERO.get();

    public WinCounter() {
        winCounts = new LinkedHashMap<>();
        for (WinType winType : WinType.values()) {
            winCounts.put(winType, ZERO);
        }
    }

    public int getCount(WinType winType) {
        return winCounts.get(winType);
    }

    public void put(WinType winType, int winCount) {
        winCounts.put(winType, winCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        winCounts.forEach((winType, winCount) -> sb.append(winType.getName())
                .append(Mark.SPACE.get())
                .append(convertRewardFormat(winType))
                .append(Mark.STATISTICS_JOIN_HYPHEN.get())
                .append(winCount)
                .append(Mark.WIN_COUNT_UNIT.get())
                .append(Mark.NEW_LINE.get()));
        if (sb.length() > ZERO) {
            sb.setLength(sb.length() - Mark.NEW_LINE.get().length());
        }
        return sb.toString();
    }

    private String convertRewardFormat(WinType winType) {
        StringBuilder sb = new StringBuilder();
        sb.append(Mark.OPEN_BRACKET.get())
                .append(convertMoneyFormat(winType.getReward()))
                .append(Mark.MONEY_UNIT.get())
                .append(Mark.CLOSE_BRACKET.get());
        return sb.toString();
    }

    private static String convertMoneyFormat(BigDecimal money) {
        DecimalFormat df = new DecimalFormat(Mark.MONEY_PATTERN.get());
        return df.format(money);
    }

    public String getRateOfReturn(BigDecimal paidMoney) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Map.Entry<WinType, Integer> entry : winCounts.entrySet()) {
            BigDecimal reward = entry.getKey().getReward();
            int count = entry.getValue();
            BigDecimal totalReward = reward.multiply(BigDecimal.valueOf(count));
            sum = sum.add(totalReward);
        }

        BigDecimal rate = sum.divide(paidMoney)
                .multiply(BigDecimal.valueOf(Value.HUNDRED.get()))
                .setScale(2, RoundingMode.HALF_UP);
        return rate.stripTrailingZeros().toPlainString() + Mark.PERCENT.get();
    }
}
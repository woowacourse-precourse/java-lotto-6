package lotto.model;

import static lotto.enumerate.ConfigInteger.LONG_ROUND_DIVIDE_NUMBER;
import static lotto.enumerate.ConfigInteger.LONG_ROUND_NUMBER;
import static lotto.enumerate.ConfigString.WINNING_STRING_FIRST;

import java.util.Map.Entry;
import lotto.enumerate.Rank;
import lotto.record.AmountRecord;
import lotto.record.ProfitRate;

public class WinningList {

    private final WinningInfo winningInfo;

    public WinningList(WinningInfo winningInfo) {
        this.winningInfo = winningInfo;
    }

    public String printWinningListString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STRING_FIRST.getString());
        winningInfo.getRankMap().forEach((key, value) -> sb.append(key.getRankString(value)));
        return sb.toString();
    }

    public ProfitRate calculateProfitRate(AmountRecord amountRecord) {
        long sum = winningInfo.getRankMap().entrySet().stream().mapToLong(this::calculateProfit).sum();
        double originalRate = (double) sum / amountRecord.amount();
        double roundedRate =
                (double) Math.round(originalRate * LONG_ROUND_NUMBER.getInt()) / LONG_ROUND_NUMBER.getInt()
                        * LONG_ROUND_DIVIDE_NUMBER.getInt();
        return new ProfitRate(originalRate, roundedRate);
    }

    private long calculateProfit(Entry<Rank, Integer> rankIntegerEntry) {
        Rank rank = rankIntegerEntry.getKey();
        int value = rankIntegerEntry.getValue();
        return rank.calculate(value);
    }
}

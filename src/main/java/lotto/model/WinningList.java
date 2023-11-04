package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.enumerate.Rank;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import lotto.record.ProfitRate;

public class WinningList {
    private static final String WINNING_STRING_FIRST = "당첨 통계\n---\n";
    private final Map<Rank, Integer> winningList;

    public WinningList(List<LottoNumberRecord> lottoNumberRecordList, WinningNumber winningNumber) {
        winningList = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningList.put(rank, 0);
        }
        for (LottoNumberRecord lotto : lottoNumberRecordList) {
            Rank rank = calculateRank(lotto, winningNumber);
            if (rank != null) {
                winningList.put(rank, winningList.get(rank) + 1);
            }
        }
    }

    public String printWinningListString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STRING_FIRST);
        Map<Rank, Integer> sortedWinningList = sortMap();
        winningList.forEach((key, value) -> sb.append(key.getRankString(value)));
        return sb.toString();
    }

    private EnumMap<Rank, Integer> sortMap() {
        return winningList.entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1,
                        () -> new EnumMap<>(Rank.class)));
    }

    public ProfitRate calculateProfitRate(AmountRecord amountRecord) {
        long sum = winningList.entrySet().stream().mapToLong(this::calculateProfit).sum();
        double originalRate = (double) sum / amountRecord.amount();
        double roundedRate = (double) Math.round(originalRate * 1000) / 1000 * 100;
        return new ProfitRate(originalRate, roundedRate);
    }

    private long calculateProfit(Entry<Rank, Integer> rankIntegerEntry) {
        Rank rank = rankIntegerEntry.getKey();
        int value = rankIntegerEntry.getValue();
        return rank.calculate(value);
    }

    private Rank calculateRank(LottoNumberRecord lottoNumberRecord, WinningNumber winningNumber) {
        int matchingNumbers = winningNumber.countMatchingNumbers(lottoNumberRecord);
        boolean hasMatchingBonusNumber = winningNumber.hasMatchingBonusNumber(lottoNumberRecord);

        if (matchingNumbers == 6) {
            return Rank.FIRST_PLACE;
        }
        if (matchingNumbers == 5 && hasMatchingBonusNumber) {
            return Rank.SECOND_PLACE;
        }
        if (matchingNumbers == 5) {
            return Rank.THIRD_PLACE;
        }
        if (matchingNumbers == 4) {
            return Rank.FOURTH_PLACE;
        }
        if (matchingNumbers == 3) {
            return Rank.FIFTH_PLACE;
        }
        return null;
    }
}

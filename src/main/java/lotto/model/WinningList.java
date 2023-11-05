package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.enumerate.Rank;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import lotto.record.ProfitRate;

public class WinningList {
    private static final String WINNING_STRING_FIRST = "당첨 통계\n---\n";
    private static final int LONG_ROUND_NUMBER = 1000;
    private static final int LONG_ROUND_DIVIDE_NUMBER = 100;

    private static final int FIRST_PLACE_MATCH = 6;
    private static final int SECOND_PLACE_MATCH = 5;
    private static final int THIRD_PLACE_MATCH = 4;
    private static final int FORTH_PLACE_MATCH = 3;

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

    private static Rank getRank(int matchingNumbers, boolean hasMatchingBonusNumber) {
        if (matchingNumbers == FIRST_PLACE_MATCH) {
            return Rank.FIRST_PLACE;
        }
        if (matchingNumbers == SECOND_PLACE_MATCH && hasMatchingBonusNumber) {
            return Rank.SECOND_PLACE;
        }
        if (matchingNumbers == SECOND_PLACE_MATCH) {
            return Rank.THIRD_PLACE;
        }
        if (matchingNumbers == THIRD_PLACE_MATCH) {
            return Rank.FOURTH_PLACE;
        }
        if (matchingNumbers == FORTH_PLACE_MATCH) {
            return Rank.FIFTH_PLACE;
        }
        return null;
    }

    public String printWinningListString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STRING_FIRST);
        winningList.forEach((key, value) -> sb.append(key.getRankString(value)));
        return sb.toString();
    }

    public ProfitRate calculateProfitRate(AmountRecord amountRecord) {
        long sum = winningList.entrySet().stream().mapToLong(this::calculateProfit).sum();
        double originalRate = (double) sum / amountRecord.amount();
        double roundedRate =
                (double) Math.round(originalRate * LONG_ROUND_NUMBER) / LONG_ROUND_NUMBER * LONG_ROUND_DIVIDE_NUMBER;
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

        return getRank(matchingNumbers, hasMatchingBonusNumber);
    }
}

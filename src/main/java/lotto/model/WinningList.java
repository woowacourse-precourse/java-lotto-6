package lotto.model;

import static lotto.enumerate.ConfigInteger.FIRST_PLACE_MATCH;
import static lotto.enumerate.ConfigInteger.FORTH_PLACE_MATCH;
import static lotto.enumerate.ConfigInteger.LONG_ROUND_DIVIDE_NUMBER;
import static lotto.enumerate.ConfigInteger.LONG_ROUND_NUMBER;
import static lotto.enumerate.ConfigInteger.ONE;
import static lotto.enumerate.ConfigInteger.SECOND_PLACE_MATCH;
import static lotto.enumerate.ConfigInteger.THIRD_PLACE_MATCH;
import static lotto.enumerate.ConfigInteger.ZERO;
import static lotto.enumerate.ConfigString.WINNING_STRING_FIRST;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.enumerate.Rank;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import lotto.record.ProfitRate;

public class WinningList {


    private final Map<Rank, Integer> winningList;

    public WinningList(List<LottoNumberRecord> lottoNumberRecordList, WinningNumber winningNumber) {
        winningList = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningList.put(rank, ZERO.getInt());
        }
        for (LottoNumberRecord lotto : lottoNumberRecordList) {
            Rank rank = calculateRank(lotto, winningNumber);
            putWinningList(rank);
        }
    }

    private void putWinningList(Rank rank) {
        if (rank != null) {
            winningList.put(rank, winningList.get(rank) + ONE.getInt());
        }
    }

    private static Rank getRank(int matchingNumbers, boolean hasMatchingBonusNumber) {
        if (matchingNumbers == FIRST_PLACE_MATCH.getInt()) {
            return Rank.FIRST_PLACE;
        }
        if (matchingNumbers == SECOND_PLACE_MATCH.getInt() && hasMatchingBonusNumber) {
            return Rank.SECOND_PLACE;
        }
        if (matchingNumbers == SECOND_PLACE_MATCH.getInt()) {
            return Rank.THIRD_PLACE;
        }
        if (matchingNumbers == THIRD_PLACE_MATCH.getInt()) {
            return Rank.FOURTH_PLACE;
        }
        if (matchingNumbers == FORTH_PLACE_MATCH.getInt()) {
            return Rank.FIFTH_PLACE;
        }
        return null;
    }

    public String printWinningListString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STRING_FIRST.getString());
        winningList.forEach((key, value) -> sb.append(key.getRankString(value)));
        return sb.toString();
    }

    public ProfitRate calculateProfitRate(AmountRecord amountRecord) {
        long sum = winningList.entrySet().stream().mapToLong(this::calculateProfit).sum();
        double originalRate = (double) sum / amountRecord.amount();
        double roundedRate =
                (double) Math.round(originalRate * LONG_ROUND_NUMBER.getInt()) / LONG_ROUND_NUMBER.getInt() * LONG_ROUND_DIVIDE_NUMBER.getInt();
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

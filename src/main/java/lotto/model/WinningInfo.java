package lotto.model;

import static lotto.enumerate.ConfigInteger.ONE;
import static lotto.enumerate.ConfigInteger.ZERO;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enumerate.Rank;
import lotto.record.LottoNumberRecord;

public class WinningInfo {

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }

    private final Map<Rank, Integer> rankMap;

    public WinningInfo(List<LottoNumberRecord> lottoNumberRecordList, WinningNumber winningNumber) {
        this.rankMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, ZERO.getInt());
        }
        for (LottoNumberRecord lotto : lottoNumberRecordList) {
            Rank rank = calculateRank(lotto, winningNumber);
            putWinningList(rank);
        }
    }

    private void putWinningList(Rank rank) {
        if (rank != null) {
            rankMap.put(rank, rankMap.get(rank) + ONE.getInt());
        }
    }

    private Rank getRank(int matchingNumbers, boolean hasMatchingBonusNumber) {
        return Rank.match(matchingNumbers, hasMatchingBonusNumber);
    }

    private Rank calculateRank(LottoNumberRecord lottoNumberRecord, WinningNumber winningNumber) {
        int matchingNumbers = winningNumber.countMatchingNumbers(lottoNumberRecord);
        boolean hasMatchingBonusNumber = winningNumber.hasMatchingBonusNumber(lottoNumberRecord);

        return getRank(matchingNumbers, hasMatchingBonusNumber);
    }
}

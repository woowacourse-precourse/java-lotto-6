package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.utils.LottoUtils.getEarningResult;
import static lotto.utils.LottoUtils.roundToFirstDecimal;

public class LottoMachine {
    private final Map<Rank, Integer> winningRecord;

    public LottoMachine() {
        winningRecord = new EnumMap<>(Rank.class);
        for (Rank value : Rank.values()) {
            winningRecord.put(value, 0);
        }
    }

    public void calculateWinningRecord(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            Rank rank = winningNumbers.determineRank(lotto);
            updateWinningRecord(rank);
        }
    }

    public void updateWinningRecord(Rank rank) {
        if (rank == Rank.PASS)
            return;
        winningRecord.put(rank, getRankValue(rank) + 1);
    }

    public double calculateEarningRate(int lottoCount) {
        double totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.PASS) continue;
            totalPrize += rank.getReward() * getRankValue(rank);
        }

        double result = getEarningResult(lottoCount, totalPrize);
        return roundToFirstDecimal(result);
    }


    public int getRankValue(Rank rank) {
        return winningRecord.get(rank);
    }

    public Map<Rank, Integer> getWiningResult() {
        return new EnumMap<>(winningRecord);
    }

}
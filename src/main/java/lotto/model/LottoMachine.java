package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.message.LottoMessage.EXIST_BONUS_MESSAGE;
import static lotto.message.LottoMessage.NOT_EXIST_BONUS_MESSEAGE;

public class LottoMachine {
    private final Map<Rank, Integer> winningRecord;

    public LottoMachine() {
        winningRecord = new EnumMap<>(Rank.class);
        for (Rank value : Rank.values()) {
            winningRecord.put(value, 0);
        }
    }

    public void showWinningResult(List<Lotto> lottos, WinningNumbers winningNumbers) {

        calculateResult(lottos, winningNumbers);

        printResult();
    }

    private void calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
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

    private void printResult() {
        winningRecord.entrySet().stream().filter(entry -> entry.getKey() != Rank.PASS)
                .forEach(entry -> {
                    int winningCount = entry.getKey().getWinningCount();
                    String reward = entry.getKey().rewardNumberFormat();
                    int myWinningCount = entry.getValue();

                    if (entry.getKey().isBonus()) {
                        System.out.printf(EXIST_BONUS_MESSAGE.getMessage(), winningCount, reward, myWinningCount);
                        System.out.println();
                    }

                    if (!entry.getKey().isBonus()) {
                        System.out.printf(NOT_EXIST_BONUS_MESSEAGE.getMessage(), winningCount, reward, myWinningCount);
                        System.out.println();
                    }

                });
    }

    public int getRankValue(Rank rank) {
        return winningRecord.get(rank);
    }

}

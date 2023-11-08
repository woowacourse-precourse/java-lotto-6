package lotto.domain;

import lotto.constant.LottoConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum WinningRecord {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    NONE(0, 0);

    private final int matchNumber;
    private final int prize;

    WinningRecord(int matchNumber, int prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static List<WinningRecord> getResultValues() {
        List<WinningRecord> winningRecords = new ArrayList<>(
                Stream.of(WinningRecord.values())
                .filter(rank -> rank.matchNumber >= 3)
                .toList());

        Collections.reverse(winningRecords);
        return winningRecords;
    }

    public static WinningRecord getPlaceType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isInRank(rank, matchNumbers, matchBonus))
                .findAny().orElse(NONE);
    }

    private boolean isInRank(WinningRecord rank, int matchNumbers, boolean matchBonus) {
        if ((rank == SECOND_PLACE && matchBonus)
                || (rank == THIRD_PLACE && !matchBonus)
                || (rank != SECOND_PLACE && rank != THIRD_PLACE)) {
            return isMatch(rank.matchNumber, matchNumbers);
        }
        return false;
    }

    private boolean isMatch(int rankMatchNumber, int matchNumbers) {
        return rankMatchNumber == matchNumbers;
    }

    public String getResultMessage(int count) {
        if(isSecondPlace(matchNumber, prize)) {
            return String.format(LottoConstant.LOTTO_WINNING_STATICS_BONUS_MESSAGE, matchNumber, prize, count);
        }
        return String.format(LottoConstant.LOTTO_WINNING_STATICS_RESULT_MESSAGE, matchNumber, prize, count);
    }

    private boolean isSecondPlace(int matchNumbers, int prize) {
        return matchNumbers == SECOND_PLACE.getMatchNumber() && prize == SECOND_PLACE.getPrize();
    }
}

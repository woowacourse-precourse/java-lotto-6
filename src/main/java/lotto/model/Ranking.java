package lotto.model;

import static lotto.constant.RankingConstant.DONT_HAVE_BONUS_NUMBER;
import static lotto.constant.RankingConstant.FIFTH_RANKING_REFERENCE_ACCORDED_COUNT;
import static lotto.constant.RankingConstant.FIFTH_RANKING_WINNING_AMOUNT;
import static lotto.constant.RankingConstant.FIRST_RANKING_REFERENCE_ACCORDED_COUNT;
import static lotto.constant.RankingConstant.FIRST_RANKING_WINNING_AMOUNT;
import static lotto.constant.RankingConstant.FOURTH_RANKING_REFERENCE_ACCORDED_COUNT;
import static lotto.constant.RankingConstant.FOURTH_RANKING_WINNING_AMOUNT;
import static lotto.constant.RankingConstant.HAS_BONUS_NUMBER;
import static lotto.constant.RankingConstant.NO_RANKING_ACCORDED_COUNT;
import static lotto.constant.RankingConstant.NO_RANKING_WINNING_AMOUNT;
import static lotto.constant.RankingConstant.SECOND_AND_THIRD_RANKING_REFERENCE_ACCORDED_COUNT;
import static lotto.constant.RankingConstant.SECOND_RANKING_WINNING_AMOUNT;
import static lotto.constant.RankingConstant.THIRD_RANKING_WINNING_AMOUNT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {
    NO_RANK(NO_RANKING_ACCORDED_COUNT, DONT_HAVE_BONUS_NUMBER, NO_RANKING_WINNING_AMOUNT),
    FIFTH_RANKING(FIFTH_RANKING_REFERENCE_ACCORDED_COUNT, DONT_HAVE_BONUS_NUMBER, FIFTH_RANKING_WINNING_AMOUNT),
    FOURTH_RANKING(FOURTH_RANKING_REFERENCE_ACCORDED_COUNT, DONT_HAVE_BONUS_NUMBER, FOURTH_RANKING_WINNING_AMOUNT),
    THIRD_RANKING(SECOND_AND_THIRD_RANKING_REFERENCE_ACCORDED_COUNT, DONT_HAVE_BONUS_NUMBER,
            THIRD_RANKING_WINNING_AMOUNT),
    SECOND_RANKING(SECOND_AND_THIRD_RANKING_REFERENCE_ACCORDED_COUNT, HAS_BONUS_NUMBER, SECOND_RANKING_WINNING_AMOUNT),
    FIRST_RANKING(FIRST_RANKING_REFERENCE_ACCORDED_COUNT, DONT_HAVE_BONUS_NUMBER, FIRST_RANKING_WINNING_AMOUNT);

    private final int accordedCount;
    private final boolean hasBonusNumber;
    private final int winningAmount;

    private Ranking(int accordedCount, boolean hasBonusNumber, int winningAmount) {
        this.accordedCount = accordedCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static Ranking getRanking(int accordedCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values()).filter(ranking -> ranking.accordedCount == accordedCount)
                .filter(ranking -> ranking.hasBonusNumber == hasBonusNumber)
                .findAny().orElse(NO_RANK);
    }

    public static List<Ranking> getRankings() {
        return Arrays.stream(Ranking.values()).collect(Collectors.toList());
    }

    public int getAccordedCount() {
        return accordedCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}

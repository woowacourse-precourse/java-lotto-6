package lotto.domain;

import lotto.dto.LottoWinningResultDTO;

import static lotto.constants.DomainConstants.*;
import static lotto.constants.DomainConstants.FIRST_NUMBER_MATCH_COUNT;

public class Rank {

    private int firstRankCount;
    private int secondRankCount;
    private int thirdRankCount;
    private int fourthRankCount;
    private int fifthRankCount;

    private Rank() {
        firstRankCount = RANK_COUNT_INIT.getValue();
        secondRankCount = RANK_COUNT_INIT.getValue();
        thirdRankCount = RANK_COUNT_INIT.getValue();
        fourthRankCount = RANK_COUNT_INIT.getValue();
        fifthRankCount = RANK_COUNT_INIT.getValue();
    }

    public static Rank create() {
        return new Rank();
    }

    public void updateRank(final int numberMatchCount, final boolean isBonusNumberMatch) {
        updateFirstRankCount(numberMatchCount);
        updateSecondRankCount(numberMatchCount, isBonusNumberMatch);
        updateThirdRankCount(numberMatchCount, isBonusNumberMatch);
        updateFourthRankCount(numberMatchCount);
        updateFifthRankCount(numberMatchCount);
    }

    private void updateFirstRankCount(final int numberMatchCount) {
        if (numberMatchCount == FIRST_NUMBER_MATCH_COUNT.getValue()) {
            firstRankCount++;
        }
    }

    private void updateSecondRankCount(final int numberMatchCount, final boolean isBonusNumberMatch) {
        if (numberMatchCount == SECOND_NUMBER_MATCH_COUNT.getValue() && isBonusNumberMatch) {
            fourthRankCount++;
        }
    }

    private void updateThirdRankCount(final int numberMatchCount, final boolean isBonusNumberMatch) {
        if (numberMatchCount == THIRD_NUMBER_MATCH_COUNT.getValue() && !isBonusNumberMatch) {
            thirdRankCount++;
        }
    }

    private void updateFourthRankCount(final int numberMatchCount) {
        if (numberMatchCount == FOURTH_NUMBER_MATCH_COUNT.getValue()) {
            secondRankCount++;
        }
    }

    private void updateFifthRankCount(final int numberMatchCount) {
        if (numberMatchCount == FIFTH_NUMBER_MATCH_COUNT.getValue()) {
            fifthRankCount++;
        }
    }

    public LottoWinningResultDTO toDTO() {
        return new LottoWinningResultDTO(
                firstRankCount,
                secondRankCount,
                thirdRankCount,
                fourthRankCount,
                fifthRankCount
        );
    }
}

package lotto.domain.statistics;

import static lotto.domain.statistics.LottoRank.FIFTH_PLACE;
import static lotto.domain.statistics.LottoRank.SECOND_PLACE;
import static lotto.domain.statistics.LottoRank.THIRD_PLACE;

import java.util.Arrays;

public class LottoResult {

    private final int countOfSameNumber;
    private final boolean matchBonusNumber;
    private final LottoRank rank;

    public LottoResult(int countOfSameNumber, boolean matchBonusNumber) {
        this.countOfSameNumber = countOfSameNumber;
        this.matchBonusNumber = matchBonusNumber;
        rank = setRank();
    }

    public LottoRank getRank() {
        return rank;
    }

    public int getCountOfSameNumber() {
        return countOfSameNumber;
    }

    public boolean getMatchBonusNumber() {
        return matchBonusNumber;
    }

    private LottoRank setRank() {
        if(checkFail()) {
            return null;
        }
        if(checkSecondOrThirdPlace()) {
            return getSecondOrThirdPlace();
        }
        return getOtherRanks();
    }

    private boolean checkFail() {
        return countOfSameNumber < FIFTH_PLACE.getStandard();
    }

    private boolean checkSecondOrThirdPlace() {
        return countOfSameNumber == SECOND_PLACE.getStandard();
    }
    private LottoRank getSecondOrThirdPlace() {
        if(matchBonusNumber) return SECOND_PLACE;
        return THIRD_PLACE;
    }

    private LottoRank getOtherRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getStandard() == countOfSameNumber)
                .toList()
                .get(0);
    }


}

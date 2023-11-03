package lotto.model;

import java.util.Objects;

public class winningDetailsResult {
    private final int matchingLottoNumber;
    private boolean checkBonusBall = false;

    public winningDetailsResult(final int matchingLottoNumber, final boolean checkBonusBall) {
        this.matchingLottoNumber = matchingLottoNumber;

        if (matchingLottoNumber == 5) {
            this.checkBonusBall = checkBonusBall;
        }
    }

    public int getMatchingLottoNumber() {
        return matchingLottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        winningDetailsResult that = (winningDetailsResult) o;
        return matchingLottoNumber == that.matchingLottoNumber && checkBonusBall == that.checkBonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingLottoNumber, checkBonusBall);
    }
}

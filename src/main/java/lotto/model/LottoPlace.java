package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPlace {
    FIRST(6, false, new Money(5000)),
    SECOND(5, true, new Money(5000)),
    THIRD(5, false, new Money(5000)),
    FOURTH(4, false, new Money(5000)),
    FIFTH(3, false, new Money(5000));

    private final int countCorrectNumber;
    private final Boolean isBonusNumberCorrect;
    private final Money prizeAmount;

    LottoPlace(int countCorrectNumber, Boolean isBonusNumberCorrect, Money prizeAmount) {
        this.countCorrectNumber = countCorrectNumber;
        this.isBonusNumberCorrect = isBonusNumberCorrect;
        this.prizeAmount = prizeAmount;
    }

    public Optional<LottoPlace> judgeLottoPlace(int countCorrectNumber, boolean isBonusNumberCorrect) {
        return Arrays.stream(LottoPlace.values())
                .filter((lottoPlace) -> lottoPlace.isRightPlace(countCorrectNumber, isBonusNumberCorrect))
                .findAny();
    }

    private boolean isRightPlace(int countCorrectNumber, boolean isBonusNumberCorrect) {
        if (this.countCorrectNumber != countCorrectNumber) {
            return false;
        }
        if (this.countCorrectNumber == 5) {
            return this.isBonusNumberCorrect == isBonusNumberCorrect;
        }
        return true;
    }
}

package lotto.domain.prize;

import java.util.Objects;
import lotto.domain.lotto.LottoNumber;

public final class PrizeNumber extends LottoNumber {
    private final PrizeNumberType prizeNumberType;

    public PrizeNumber(final int number) {
        super(number);
        this.prizeNumberType = PrizeNumberType.PRIZE;
    }

    public PrizeNumber(
            int number,
            PrizeNumberType prizeNumberType
    ) {
        super(number);
        this.prizeNumberType = prizeNumberType;
    }

    public PrizeNumberType getPrizeNumberType() {
        return prizeNumberType;
    }

    public boolean isPrizeType() {
        return prizeNumberType == PrizeNumberType.PRIZE;
    }

    public boolean isBonusType() {
        return prizeNumberType == PrizeNumberType.BONUS;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, prizeNumberType);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (other instanceof PrizeNumber otherPrizeNumber) {
            return number == otherPrizeNumber.number && prizeNumberType == otherPrizeNumber.prizeNumberType;
        }

        if (other instanceof LottoNumber otherLottoNumber) {
            return super.equals(otherLottoNumber);
        }

        return false;
    }
}

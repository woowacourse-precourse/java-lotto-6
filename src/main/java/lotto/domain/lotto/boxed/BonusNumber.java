package lotto.domain.lotto.boxed;

public final class BonusNumber extends LottoNumber {
    public BonusNumber(final int value) {
        super(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        return value == ((BonusNumber) o).value;
    }
}

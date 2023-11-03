package lotto.domain.lotto.boxed;

public final class BonusNumber extends LottoNumber {
    /**
     * @apiNote LottoNumber 생성 시, <h3 color="#bf0f4d">value는 반드시 1 이상 45 이하의 범위에 속해야 합니다.</h3>
     */
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

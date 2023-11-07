package lotto.element;

public class Bonus {
    private final int number;

    public Bonus(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    void validate(int num, Lotto lotto) {
        if (lotto.getLottoNumbers().contains(num)) {
            throw new IllegalArgumentException("번호가 중복됩니다.");
        }
    }

    public boolean isBonusMatch(Lotto other) {
        return other.getLottoNumbers().contains(number);
    }
}

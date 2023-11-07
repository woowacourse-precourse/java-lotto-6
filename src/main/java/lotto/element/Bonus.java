package lotto.element;

public class Bonus {
    private int number;

    Bonus(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    void validate(int num, Lotto lotto) {
        if (lotto.getLottoNumbers().contains(num)) {
            throw new IllegalArgumentException("번호가 중복됩니다.");
        }
    }
}

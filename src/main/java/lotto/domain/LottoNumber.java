package lotto.domain;

/**
 * 로또 게임에서 사용되는 개별 번호를 나타내는 클래스.
 */
public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean matches(int otherNumber) {
        return this.number == otherNumber;
    }
}

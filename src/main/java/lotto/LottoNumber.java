package lotto;

public class LottoNumber {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        checkRange();
    }

    private void checkRange() {
        if (!isValidRange()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private boolean isValidRange() {
        return number >= MINIMUM && number <= MAXIMUM;
    }
}

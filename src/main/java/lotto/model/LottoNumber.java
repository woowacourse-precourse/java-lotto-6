package lotto.model;

public class LottoNumber {

    private final static int LOTTO_NUMBER_MIN_RANGE = 1;
    private final static int LOTTO_NUMBER_MAX_RANGE = 45;

    private final int winningNumber;

    public LottoNumber(int winningNumber) {
        validateWinningNumberRange(winningNumber);
        this.winningNumber = winningNumber;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    private void validateWinningNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

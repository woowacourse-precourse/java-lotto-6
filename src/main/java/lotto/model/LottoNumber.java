package lotto.model;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;

    private final int winningLottoNumber;

    public LottoNumber(int winningLottoNumber) {
        validateWinningNumberRange(winningLottoNumber);
        this.winningLottoNumber = winningLottoNumber;
    }

    public int getWinningNumber() {
        return winningLottoNumber;
    }

    public static int getLottoNumberMinRange() {
        return LOTTO_NUMBER_MIN_RANGE;
    }

    public static int getLottoNumberMaxRange() {
        return LOTTO_NUMBER_MAX_RANGE;
    }

    private void validateWinningNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

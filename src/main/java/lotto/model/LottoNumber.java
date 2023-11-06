package lotto.model;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateWinningNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void validateWinningNumberRange(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_MIN_RANGE || lottoNumber > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

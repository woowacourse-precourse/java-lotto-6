package lotto.domain.constants;

public class LottoConstants {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_LOTTO_NUMBER_RANGE =
            String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

    private LottoConstants() {
    }
}

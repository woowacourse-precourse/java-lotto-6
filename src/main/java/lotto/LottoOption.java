package lotto;

public class LottoOption {
    private LottoOption() {
        throw new IllegalArgumentException("정적 클래스를 생성하였습니다.");
    }

    public static int LOTTO_SIZE = 6;
    public static int LOTTO_MIN_NUMBER = 1;
    public static int LOTTO_MAX_NUMBER = 45;
}

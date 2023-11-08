package lotto.domain;

public class LottoOption {
    public static final int LOTTO_PRICE = 1_000;
    public static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_START_INCLUSIVE = 1;
    public static final int LOTTO_END_INCLUSIVE = 45;

    private LottoOption() {
        // 불필요한 인스턴스 생성 방지
    }
}

package lotto.model;

public class LottoNo {
    private static final int MIN_NO = 1;
    private static final int MAX_NO = 45;
    private static final String WRONG_LOTTO_NO = "[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.";
    private final int no;

    public LottoNo(int no) {
        validate(no);
        this.no = no;
    }

    private void validate(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException(WRONG_LOTTO_NO);
        }
    }
}

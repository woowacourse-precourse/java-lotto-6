package lotto.model;

public record LottoNo(int no) {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 45;
    private static final String WRONG_LOTTO_NO = "[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.";

    public LottoNo {
        validate(no);
    }

    private void validate(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException(WRONG_LOTTO_NO);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }
}

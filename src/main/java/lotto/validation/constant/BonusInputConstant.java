package lotto.validation.constant;

public enum BonusInputConstant {

    DUPLICATION_BONUS_NUMBER("[ERROR] 보너스 번호와 당첨 번호는 중복 될 수 없습니다."),
    NUMBER_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    SPLIT_MESSAGE(","),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private String message;
    private int number;

    BonusInputConstant(final String message) {
        this.message = message;
    }
    BonusInputConstant(final int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}

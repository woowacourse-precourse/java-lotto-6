package lotto.util;

public enum Error {
    MONEY_ZERO_ERROR("[ERROR] 구입 금액은 1000원 이상이여야 합니다."),
    MONEY_DIVIDE_ERROR("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6자리 이여야 합니다."),
    INPUT_DIGIT_ERROR("[ERROR] 숫자만 입력 가능합니다."),
    INPUT_BLANK_ERROR("[ERROR] 잘못된 입력입니다."),
    BONUS_DUPLICATE_ERROR("[ERROR] 당첨 번호와 중복입니다. ");

    private final String message;

    private Error(String message) {
        this.message = message;
    }

    public String message(){
        return message;
    }
}

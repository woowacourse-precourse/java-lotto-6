package lotto.util;

public enum ErrorMessage {
    ERROR_INPUT_PRICE_MESSAGE(LottoValues.LOTTO_PRICE + "원 단위 숫자로 입력해야 합니다."),
    ERROR_LOTTO_COUNT_MESSAGE(LottoValues.LOTTO_PRICE + "원 이상의 나누어 떨어지는 값을 입력해야 합니다."),
    ERROR_INPUT_NOT_NUMBER_MESSAGE("번호는 숫자로 입력해주세요"),
    ERROR_VALIDATE_BONUS_DUPLICATE_MESSAGE("보너스 번호는 중복될 수 없습니다."),
    ERROR_VALIDATE_NUMBER_COUNT_MESSAGE("번호는 "+LottoValues.LOTTO_NUMBER_COUNT+"개 입니다."),
    ERROR_VALIDATE_NUMBER_DUPLICATE_MESSAGE("로또 번호는 중복될 수 없습니다."),
    ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE("로또 번호는 "
            + LottoValues.MIN_LOTTO_NUMBER + "부터 " + LottoValues.MAX_LOTTO_NUMBER + " 사이 값을 입력해야 합니다.");

    private String message;
    private static final String ERROR_PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + message;
    }
}

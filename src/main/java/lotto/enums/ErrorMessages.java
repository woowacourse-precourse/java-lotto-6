package lotto.enums;

public enum ErrorMessages {
    OVER_MAX_SIZE_MESSAGE("로또 번호의 개수가 %s개가 넘어가면 안됩니다".formatted(LottoEnum.SELECTED_NUMBERS_SIZE.getValue())),
    DUPLICATE_NUMBER_MESSAGE("로또 발행시 중복되지 않는 %d개의 숫자가 있어야 합니다.".formatted(LottoEnum.SELECTED_NUMBERS_SIZE.getValue())),
    INVALID_NUMBER_RANGE_MESSAGE("로또 번호의 숫자 범위는 %s~%s 입니다.".formatted(LottoEnum.MIN_LOTTO_NUMBER.getValue(), LottoEnum.MAX_LOTTO_NUMBER.getValue()))
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}

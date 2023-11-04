package lotto.domain.lotto;

enum LottoExceptionMessages {

    INVALID_NUMBERS_COUNT(String.format(
            "로또 번호의 개수는 %d개이어야 합니다.",
            LottoConfig.NUMBERS_COUNT.getValue()
    )),

    DUPLICATED_NUMBERS_COUNT(
            "로또 번호는 중복된 값이 없어야 합니다."
    ),

    INVALID_NUMBER_RANGE(String.format(
            "로또 번호는 %d부터 %d 사이의 숫자이어야 합니다.",
            LottoConfig.MIN_NUMBER.getValue(),
            LottoConfig.MAX_NUMBER.getValue()
    )),

    DUPLICATED_BONUS_NUMBER(
            "보너스 번호는 당첨 번호와 중복된 값이 없어야 합니다."
    );

    private final String message;

    LottoExceptionMessages(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}

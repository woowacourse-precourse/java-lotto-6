package lotto.domain.model;

import lotto.domain.LottoConfig;

enum LottoErrorMessages {
    INVALID_NUMBER_RANGE(
            String.format("Lotto 숫자는 %d부터 %d까지 입니다.",
                    LottoConfig.MIN_NUMBER.getValue(),
                    LottoConfig.MAX_NUMBER.getValue())),
    INVALID_SIZE(
            String.format("로또 숫자는 %d개여야 합니다.",
                    LottoConfig.NUMBER_COUNT.getValue())),
    INVALID_LOTTO_PRICE("로또 가격은 양수여야 합니다."),
    DUPLICATE_NUMBERS("로또 숫자는 중복될 수 없습니다."),
    NEGATIVE_AMOUNT("금액은 양수여야 합니다."),
    NOT_DIVISIBLE_AMOUNT("금액은 로또 가격 단위로 나누어 떨어져야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}

package lotto.global;

public enum ErrorMessage {
    INVALID_NATURAL_NUMBER_ERROR("입력값은 자연수여야 합니다."),
    INVALID_LOTTO_NUMBER_ERROR("유효하지 않는 로또 번호입니다."),
    INVALID_LOTTO_SIZE_ERROR("유효하지 않는 로또 번호 개수입니다."),
    INVALID_PRICE_UNIT_ERROR(LottoInformation.LOTTO_PRICE_UNIT + "원 단위로 입력해야 합니다."),
    BONUS_BALL_INCLUDE_ERROR("보너스 볼은 당첨 번호와 중복될 수 없습니다."),
    NUMBER_DUPLICATED_ERROR("로또 번호가 중복됩니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package lotto.utils.message;

public enum LottoExceptionMessage {

    NOT_SATISFY_REQUIRED_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_SATISFY_LOTTO_NUMBER_UNIQUE("[ERROR] 로또 번호가 중복 입니다."),
    NOT_SATISFY_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1 ~ 45 범위의 수만 가능 합니다."),
    WINNING_AND_BONUS_DUPLICATE_EXISTS("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.");;

    private final String error;

    LottoExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}

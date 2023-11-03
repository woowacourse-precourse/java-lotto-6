package lotto.enumerate;

public enum ErrorCode {
    LOTTO_NUMBER_OVER_OR_UNDER_SIZE("[ERROR] 1장의 로또 번호의 갯수는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOTTO_NUMBER_UNDER_OR_OVER("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다."),
    AMOUNT_UNIT_IS_NOT_1000_WON("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다."),
    AMOUNT_IS_UNDER_ZERO_WON("[ERROR] 로또 구입 금액은 음수이거나 0이 될 수 없습니다.");

    ErrorCode(String message) {
    }
}

package lotto.enumerate;

public enum ErrorCode {
    LOTTO_NUMBER_OVER_OR_UNDER_SIZE("[ERROR] 1장의 로또 번호의 갯수는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_UNDER_OR_OVER("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");

    ErrorCode(String message) {
    }
}

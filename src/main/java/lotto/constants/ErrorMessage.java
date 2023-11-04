package lotto.constants;

public enum ErrorMessage {
    ERROR_BLANK_MESSAGE("[ERROR] 아무것도 입력하지 않았습니다."),
    ERROR_NOT_NUMBER_MESSAGE("[ERROR] 숫자만 입력할 수 있습니다."),
    ERROR_UNDER_THOUSAND_MESSAGE("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    ERROR_NOT_THOUSAND_UNITS_MESSAGE("[ERROR] 구입 금액은 1000원 단위만 허용합니다."),
    ERROR_NOT_LOTTO_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NOT_SIX_LOTTO_NUMBER_MESSAGE("[ERROR] 로또 번호는 6개의 숫자만 입력해야 합니다."),
    ERROR_OVERLAP_LOTTO_NUMBER_MESSAGE("[ERROR] 로또 번호는 중복된 숫자를 입력할 수 없습니다."),
    ERROR_OVERLAP_BONUS_LOTTO_NUMBER_MESSAGE("[ERROR] 보너스 번호는 이전에 입력한 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

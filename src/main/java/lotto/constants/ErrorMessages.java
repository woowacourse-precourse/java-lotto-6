package lotto.constants;

public enum ErrorMessages {
    WRONG_FORMAT("[ERROR] 잘못된 값이 입력되었습니다. 숫자를 입력해 주세요."),
    THOUSANDS("[ERROR] 1,000원 단위로 입력해주세요."),
    LOTTO_NUMBERS("[ERROR] 당첨 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_MINIMUM_COUNT("[ERROR] 로또는 1개이상부터 살 수 있습니다."),
    DUPLICATES("[ERROR] 중복된 번호는 입력할 수 없습니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}

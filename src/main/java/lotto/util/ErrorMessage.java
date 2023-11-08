package lotto.util;

public enum ErrorMessage {

    BUDGET("[ERROR] 구입 금액은 1000원 단위입니다."),
    NUMBER_SIZE("[ERROR] 로또 번호는 6개입니다."),
    DUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 존재합니다."),
    NUMBER_RANGE("[ERROR] 로또 번호는 1에서 45사이입니다."),
    BONUS_NUMBER("[ERROR] 로또 번호와 중복된 보너스번호를 입력했습니다."),
    INPUT_BUGET("[ERROR] 1 이상의 숫자를 입력하세요."),
    INPUT_BONUS_NUMBER("[ERROR] 1 에서 45 사이의 숫자를 입력하세요"),
    INPUT_LOTTO_NUMBER("[ERROR] 유효하지 않은 로또 번호입니다."),
    EMPTY_INPUT("[ERROR] 값을 입력해주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;

    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

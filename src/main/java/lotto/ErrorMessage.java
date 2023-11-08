package lotto;

public enum ErrorMessage {
    RANGE_IN_1_TO_45("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATE("[ERROR] 중복된 값은 입력할 수 없습니다."),
    INPUT_6_SIZE("[ERROR] 여섯 개의 숫자를 입력해주세요."),
    DO_NOT_START_ZERO("[ERROR] 0값 입력 또는 0값으로 입력을 시작할 수 없습니다."),
    INPUT_1000_UNIT("[ERROR] 1,000원 단위의 숫자를 입력해주세요.");

    final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    String getErrorMessage() {
        return errorMessage;
    }
}


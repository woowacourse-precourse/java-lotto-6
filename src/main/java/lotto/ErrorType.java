package lotto;

public enum ErrorType {
    REPITITION("[ERROR] 로또 번호는 중복되어서는 안 됩니다."),
    NUMBER("[ERROR] 총 6개의 숫자를 입력해야 합니다."),
    RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    FORMAT("[ERROR] 숫자를 입력해야 합니다."),
    SIGN("[ERROR] 구입 금액은 양수여야 합니다."),
    UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");

    private String errorMessage;

    private ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}


    /*

    "[ERROR] 로또 번호는 중복되어서는 안 됩니다."
    "[ERROR] 총 6객의 숫자를 입력해야 합니다."
    "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    "[ERROR] 숫자를 입력해야 합니다."
    "[ERROR] 구입 금액은 양수여야 합니다."
    "[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."
    "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    "[ERROR] 중복되지 않은 번호를 입력해 주세요."
     */

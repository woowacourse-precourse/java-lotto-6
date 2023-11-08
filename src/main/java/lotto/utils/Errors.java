package lotto.utils;

public enum Errors {
    ERROR_PURCHASE_MONEY_AVAILABLE("[ERROR] 1000원 단위로 구매해주세요."),
    ERROR_INPUT_NUMBER("[ERROR] 숫자 형식으로 입력해주세요."),
    ERROR_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NUMBER_DUPLICATE("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    ERROR_NUMBER_SIZE("[ERROR] 6자리를 입력해주세요."),
    ERROR_BONUS_NUMBER_DUPLICATE("[ERROR] 당첨번호와 중복된 번호는 입력할 수 없습니다. 다시 입력해주세요.");

    private String errorMessage;

    Errors(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return this.errorMessage;
    }
}

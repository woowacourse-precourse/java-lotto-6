package lotto.config;

public enum ErrorMessage {

    ERROR_PURCHASE_COST_POSITIVE_INTEGER("[ERROR] 구입 금액은 양의 정수로만 입력해야 합니다."),
    ERROR_PURCHASE_COST_MULTIPLE_1000("[ERROR] 구입 금액은 1000의 배수로만 입력해야 합니다."),
    ERROR_INPUT_WINNER_NUMBER_REGEX("[ERROR] 당첨 번호는 쉼표로 구분해서 입력해야 합니다."),
    ERROR_WINNER_NUMBER_COUNT("[ERROR] 당첨 번호는 6개만 입력해야 합니다."),
    ERROR_BONUS_NUMBER_COUNT("[ERROR] 보너스 번호는 1개만 입력해야 합니다."),
    ERROR_NUMBER_DUPLICATE("[ERROR] 중복된 번호가 있습니다."),
    ERROR_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_LOTTO_SIZE("[ERROR] 로또 번호가 6개가 아닙니다.");

    private final String errorMessage;
    private ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}

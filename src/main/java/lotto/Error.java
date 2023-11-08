package lotto;

public enum Error {
    INIT_STATE,
    NO_PROBLEM,
    INPUT_ERROR("[ERROR] 입력 양식이 잘못되었습니다. 다시 입력해주세요."),
    PRICE_ERROR("[ERROR] 구입 금액은 1000단위의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복이 없어야 합니다."),
    LOTTO_NUMBER_OUT_OF_COUNT_ERROR("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE_ERROR("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_DUPLICATE_ERROR("[ERROR] 당첨 번호는 중복이 없어야 합니다."),
    WINNING_NUMBER_OUT_OF_COUNT_ERROR("[ERROR] 당첨 번호는 6개의 숫자로 구성되어야 합니다."),
    WINNING_NUMBER_OUT_OF_RANGE_ERROR("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    public static Error printError(Error error) {
        if (error == NO_PROBLEM)
        {
            System.out.println(INPUT_ERROR.getMessage());
            return INPUT_ERROR;
        }
        System.out.println(error.getMessage());
        return error;
    }

    public String getMessage() {
        return message;
    }
}

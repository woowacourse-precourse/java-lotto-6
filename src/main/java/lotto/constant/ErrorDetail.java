package lotto.constant;

public enum ErrorDetail {
    RANGE_ERROR("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    DUPLICATED_ERROR("로또 번호는 서로 중복되면 안됩니다."),
    NUMBER_ERROR("로또 번호의 개수는 %d이어야 합니다."),
    NEGATIVE_MONEY_ERROR("금액은 양수여야 합니다."),
    WRONG_MONEY_ERROR("금액은 %d원 단위이어야 합니다.");

    private String message;

    ErrorDetail(String message) {
        this.message = message;
    }

    public String getMessage(Integer... numbers) {
        if (numbers.length == 0) {
            return message;
        } else if (numbers.length == 1) {
            return String.format(message, numbers[0]);
        } else if (numbers.length == 2) {
            return String.format(message, numbers[0], numbers[1]);
        }
        return message;
    }
}

package lotto.exception;

public class ErrorInputException extends IllegalArgumentException {
    public enum ErrorMessage {
        PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY("구입 금액은 빈 값이거나 null 값 일 수 없습니다. 다시 입력해 주세요."),
        PURCHASE_PRICE_IS_NOT_INTEGER("구입 금액은 정수만 입력 가능합니다. 다시 입력해 주세요."),
        PURCHASE_PRICE_IS_MORE_THAN_ONE("구입 금액은 1이상의 자연수여야 합니다. 다시 입력해 주세요."),
        PURCHASE_PRICE_CAN_DIVIDE_BY_THOUSAND("구입 금액은 1,000원 단위여야 합니다.다시 입력해 주세요."),

        LOTTO_NUMBER_CAN_NOT_BE_DUPLICATE("로또 번호는 중복된 숫자로 구성되면 안됩니다. 다시 입력해 주세요."),

        WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY("당첨 번호는 빈 값이거나 null 값 일 수 없습니다. 다시 입력해 주세요."),
        WINNER_NUMBER_IS_NOT_INTEGER("당첨 번호는 정수만 입력 가능합니다. 다시 입력해 주세요."),
        WINNER_NUMBER_IS_MORE_THAN_ONE("당첨 번호는 1이상의 자연수여야 합니다. 다시 입력해 주세요."),
        WINNER_NUMBER_ERROR_INPUT("유효하지 않은 입력 입니다. 다시 입력해 주세요."),
        WINNER_NUMBER_SIZE_IS_SIX("당첨 번호는 6개로 구성되어야 합니다. 다시 입력해 주세요."),
        WINNER_NUMBER_CAN_NOT_BE_DUPLICATE("당첨 번호는 중복된 숫자로 구성되면 안됩니다. 다시 입력해 주세요."),
        WINNER_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE("당첨 번호는 1 ~ 45 사이 숫자여야 합니다. 다시 입력해 주세요."),


        BONUS_NUMBER_CANNOT_BE_NULL_OR_EMPTY("보너스 번호는 빈 값이거나 null 값 일 수 없습니다. 다시 입력해 주세요."),
        BONUS_NUMBER_IS_NOT_INTEGER("보너스 번호는 정수만 입력 가능합니다. 다시 입력해 주세요."),
        BONUS_NUMBER_IS_MORE_THAN_ONE("보너스 번호는 1이상의 자연수여야 합니다. 다시 입력해 주세요."),
        BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE("보너스 번호는 1 ~ 45 사이 숫자여야 합니다. 다시 입력해 주세요."),
        BONUS_NUMBER_CAN_NOT_BE_DUPLICATE("보너스 번호는 당첨 번호와 중복된 숫자이면 안됩니다. 다시 입력해 주세요."),

        CAN_NOT_STATISTIC("당첨 조회가 불가능한 조건입니다.");


        ErrorMessage(final String message) {
            this.message = message;
        }

        private final String errorMessage = "[ERROR] ";

        private final String message;

        public String getErrorMessage() {
            return errorMessage;
        }

        public String getMessage() {
            return message;
        }

    }

    public ErrorInputException(ErrorMessage message) {
        super(message.getErrorMessage() + message.getMessage());
    }
}

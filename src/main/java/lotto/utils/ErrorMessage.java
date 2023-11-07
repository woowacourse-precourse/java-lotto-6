package lotto.utils;

public enum ErrorMessage {
    INPUT_IS_EMPTY("입력된 값이 없습니다!"),
    NON_INTEGER_VALUE("입력된 예산이 정수가 아닙니다!"),
    ONLY_ZERO_OR_MORE("예산은 0 이상의 수만 입력될 수 있습니다!"),
    UNITS_OF_1000("입력된 예산이 1000원 단위가 아닙니다!"),
    DUPLICATED_VALUES("로또 번호가 중복됩니다!"),
    NON_WINNING_NUMBER("당첨 번호는 1 이상 45 이하인 정수입니다!"),
    WINNING_NUMBER_SIZE("입력된 당첨 번호가 6개가 아닙니다!"),
    WINNING_NUMBER_IS_TOO_LONG("당첨 번호 입력이 너무 많습니다!\n 입력된 당첨 번호와 형식을 다시 확인해주세요!");

    private final String errorMessage;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        StringBuilder sb = new StringBuilder(PREFIX);
        sb.append(errorMessage);
        return sb.toString();
    }
}

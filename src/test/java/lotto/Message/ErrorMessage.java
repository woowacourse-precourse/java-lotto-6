package lotto.Message;

public enum ErrorMessage {
    LOTTO_NUMBER_OUT_OF_RANGE("당첨 번호는 1~45 사이의 숫자를 입력해주세요."),
    LOTTO_NUMBER_SHOULD_BE_SIX("로또 번호는 6자리입니다."),
    LOTTON_NUMBER_DUPLICATION("각 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("당첨 번호는 1~45 사이의 숫자를 입력해주세요."),
    BONUS_NUMBER_DUPLICATION("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    MONEY_SHOULD_BE_1000("돈은 1000원 단위로 나누어 떨어져야 합니다."),
    MONEY_SHOUD_BE_POSITIVE_NUMBER("돈은 양의 값을 입력받아야 합니다.");


    private final String errorMessage;
    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString(){
        return "[ERROR] " + errorMessage;
    }
}

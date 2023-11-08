package lotto.view.enums;

public enum ErrorMessage {
    ERROR_HEADER("[ERROR] "),
    ERROR_FOOTER("\n"),
    CANT_PARSEINT("입력값에 정수가 아닌 값 또는 공백 문자가 포함되었습니다."),
    IS_BLANK("빈 값은 입력할 수 없습니다."),
    CANT_DIVIDE("구매 금액은 1000원 단위로 입력할 수 있습니다."),
    TICKET_NUMBER_LESS_THAN_ONE("한 장 미만의 로또는 발행할 수 없습니다."),
    LOTTO_NUMBERS_WRONG_SIZE("6개의 번호로 구성되지 않은 로또는 발행할 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("1~45 범위를 벗어난 숫자가 포함된 로또는 발행할 수 없습니다."),
    LOTTO_NUMBER_DUPLICATED("중복된 숫자가 존재하는 로또는 발행할 수 없습니다."),
    WINNING_NUMBERS_WRONG_SIZE("6개의 번호로 구성되지 않은 당첨 번호는 생성할 수 없습니다."),
    WINNING_NUMBER_OUT_OF_RANGE("1~45 범위를 벗어난 숫자가 포함된 당첨 번호는 생성할 수 없습니다."),
    WINNING_NUMBER_DUPLICATED("중복이 존재하는 당첨 번호는 생성할 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("1~45 범위를 벗어난 숫자의 보너스 번호는 생성할 수 없습니다."),
    BONUS_NUMBER_DUPLICATED("당첨 번호와 중복된 보너스 번호는 생성할 수 없습니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

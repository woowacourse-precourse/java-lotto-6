package lotto;

public enum ErrorMessages {
    VALIDATE_SPACE("[ERROR] 숫자 중간에 공백이 입력되었습니다."),
    VALIDATE_OVER_ONE("[ERROR] 1개 이상이 입력되었습니다."),
    VALIDATE_POINT("[ERROR] 소수점은 입력할 수 없습니다."),
    VALIDATE_NUMBER("[ERROR] 숫자가 아닌 값이 입력되었습니다."),
    VALIDATE_DUPLICATE_BONUS("[ERROR] 당첨 번호와 중복되었습니다."),
    VALIDATE_1_TO_45("[ERROR] 로또 번호의 숫자 범위는 1~45사이 입니다."),
    VALIDATE_ZERO_LESS("[ERROR] 양의 정수를 입력해주세요."),
    VALIDATE_DUPLICATE_LOTTO("[ERROR] 중복된 숫자가 있습니다."),
    VALIDATE_6_NUMS("[ERROR] 6개의 숫자가 아닙니다."),
    VALIDATE_DIVIDED("[ERROR] 1,000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

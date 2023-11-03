package lotto.constant;

public enum ErrorMessage {
    INPUT_STRING("[ERROR] 숫자가 아닌 문자열을 입력했습니다"),
    EMPTY("[ERROR] 입력을 안 했습니다"),
    NOT_CONTAIN_COMMA("[ERROR] ',' 을 빼고 숫자만 입력해주세요"),
    NOT_DIVIDE("[ERROR] 구입금액은 1000원 단위어야 합니다"),
    STRANGE_INTEGER("[ERROR] 구입금액은 0원 보다 커야합니다"),
    OUT_OF_NUMBER_RANGE("[ERROR] 번호의 범위는 1~45 이어야 합니다"),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 있습니다"),
    WRONG_LENGTH("[ERROR] 숫자를 6개 입력하지 않았습니다"),
    CONTAIN_BLANK("[ERROR] 입력에 공백이 섞여있습니다"),
    ANOTHER_COMMA("[ERROR] 입력은 ',' 으로 구분해야합니다"),
    SEQUENCE_COMMA("[ERROR] ','를 연속해서 적었습니다");



    private String message;

    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}

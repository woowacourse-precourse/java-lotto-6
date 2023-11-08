package lotto.global.enums;

public enum ErrorMessage {
    DUPLICATED_NUMBER_VALUE("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
    INVALID_STRING_INPUT("[ERROR] 잘못된 문자열 입력입니다."), // 추가된 에러 메시지
    INVALID_WHITESPACE_INPUT("[ERROR] 문자열에는 공백이 포함될 수 없습니다."), // 추가된 에러 메시지
    INVALID_NUMBER_VALUE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_ASSET_VALUE("[ERROR] 금액은 1,000원 단위로 입력해주세요.");

    private String message;

    ErrorMessage(String message){this.message = message;}

    public String getMessage(){
        return this.message;
    }

    @Override
    public String toString(){
        return this.message;
    }
}

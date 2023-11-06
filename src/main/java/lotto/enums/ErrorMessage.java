package lotto.enums;

public enum ErrorMessage {


    INVALID_NUMBER_VALUE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_ASSET_VALUE("금액은 1,000원 단위로 입력해주세요.");

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

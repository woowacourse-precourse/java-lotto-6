package constant;

public enum ErrorMessage {
    NULL_MESSAGE("[ERROR] 입력값이 없습니다. 다시 입력 해주세요."),
    NUMBERIC_MESSAGE("[ERROR] 숫자형식이 아닙니다. 다시 입력 해주세요."),
    FIT_LOTTO_COST("[ERROR] 로또 금액에 정확이 맞춰 입력해야 합니다. (현재 로또 금액 : 1000)");

    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}

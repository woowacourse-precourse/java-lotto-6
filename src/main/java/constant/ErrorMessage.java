package constant;

public enum ErrorMessage {
    MESSAGE("[ERROR]"),
    NULL_MESSAGE("입력값이 없습니다. 다시 입력 해주세요."),
    NUMBERIC_MESSAGE("숫자형식이 아닙니다. 다시 입력 해주세요."),
    FIT_LOTTO_COST_MESSAGE("로또 금액에 정확이 맞춰 입력해야 합니다. (현재 로또 금액 : 1000)"),
    ZERO_MESSAGE("0원으로는 로또를 구매할 수 없습니다.");


    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}

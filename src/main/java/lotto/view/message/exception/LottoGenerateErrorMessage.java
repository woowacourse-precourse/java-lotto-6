package lotto.view.message.exception;

public enum LottoGenerateErrorMessage {
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복이 없어야 합니다.");

    private final String message;

    LottoGenerateErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

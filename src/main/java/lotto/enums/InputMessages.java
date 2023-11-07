package lotto.enums;

public enum InputMessages {

    PURCHASE_MONEY("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

package lotto.constant;

public enum UserRequestMessage {
    PURCHASE_COST_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    UserRequestMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}

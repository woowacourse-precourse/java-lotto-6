package output;

public enum InputMessage {
    GIVE_THE_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    GIVE_THE_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    GIVE_THE_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    InputMessage(String inputMessage){
        this.inputMessage = inputMessage;
    }

    public String message(){
        return inputMessage;
    }
}

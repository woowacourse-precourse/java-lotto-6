package message;

public enum InputMessage {
    PAYMENT("구입금액을 입력해 주세요."),
    WINNINGNUMBERS("당첨 번호를 입력해 주세요."),
    BONUSNUMBER("보너스 번호를 입력해 주세요.");

    private final String message;
    InputMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}

package view;

public enum ViewMessage {

    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_PRIZE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

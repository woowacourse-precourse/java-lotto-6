package lotto.view;

public enum GuideMessage {
    BUY_GUIDE_MESSAGE("구입금액을 입력해 주세요."),
    NUMBER_GUIDE_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_GUIDE_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    private GuideMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

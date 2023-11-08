package lotto.Lotto.model;

public enum UIMessageGroup {
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;


    UIMessageGroup(String message) {
        this.message = message;
    }

    public String getMessage() {return message;}
}

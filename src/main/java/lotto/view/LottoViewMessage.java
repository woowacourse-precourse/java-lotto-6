package lotto.view;

public enum LottoViewMessage {
    ASK_BUY_LOTTO("구입금액을 입력해 주세요"),
    ASK_WINNING_NUM("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUM("보너스 번호를 입력해 주세요.");
    private final String viewMessage;


    LottoViewMessage(String viewMessage){
        this.viewMessage = viewMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }
}

package lotto.view.message.view;

public enum ProcessMessage {
    PLEASE_INPUT_BUDGET("구입금액을 입력해 주세요.\n"),
    PURCHASE_LOTTO("개를 구매했습니다.\n"),
    PLEASE_INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    PLEASE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    ProcessMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

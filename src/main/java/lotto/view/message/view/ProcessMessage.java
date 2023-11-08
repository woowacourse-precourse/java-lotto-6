package lotto.view.message.view;

import javax.sound.midi.Soundbank;

public enum ProcessMessage {
    PLEASE_INPUT_BUDGET("구입금액을 입력해 주세요.\n"),
    PURCHASE_LOTTO("\n%d개를 구매했습니다.\n"),
    PLEASE_INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요.\n"),
    PLEASE_INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n");

    private final String message;

    ProcessMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void displayMessage(){
        System.out.println(message);
    }
}

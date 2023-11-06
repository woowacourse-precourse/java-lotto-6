package lotto.consts;

public enum MachineMessage {
    MACHINE_MESSAGE_BUY("구입금액을 입력해 주세요."),
    MACHINE_MESSAGE_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    MACHINE_MESSAGE_BONUS("보너스 번호를 입력해 주세요."),
    MACHINE_MESSAGE_PURCHASE_LIST("개를 구매했습니다."),
    MACHINE_MESSAGE_LOTTO_RESULT("당첨 통계\n---"),
    MACHINE_MESSAGE_DASH(" - "),
    MACHINE_MESSAGE_COUNT("개");

    private final String message;

    MachineMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

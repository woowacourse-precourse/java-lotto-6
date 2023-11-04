package lotto.consts;

public enum MachineMessage {
    MACHINE_MESSAGE_BUY("구입금액을 입력해 주세요.");

    private final String message;

    MachineMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

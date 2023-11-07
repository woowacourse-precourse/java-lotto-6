package lotto.collaboration.enums;

public enum WinningLottoMessage {

    EXCEPTION_DUPLICATED("당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    ;

    private final String message;

    WinningLottoMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}

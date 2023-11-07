package lotto.collaboration.dto.enums;

public enum PlayerLottoMessage {

    EXCEPTION_IS_NULL("초기화 되지 않은 로또 객체."),
    EXCEPTION_NOT_SIX("번호는 총 6개여야 합니다."),
    EXCEPTION_OUT_OF_RANGE("번호는 1부터 45까지의 숫자 중에서 선택할 수 있습니다."),
    ;

    private final String message;

    PlayerLottoMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}

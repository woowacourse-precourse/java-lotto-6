package lotto.constants;

public enum SystemMessage {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ERROR_MONEY_DIV("[ERROR] 1000 단위로 입력해 주세요."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6자리 이여야 합니다."),;
    private final String message;

    private SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

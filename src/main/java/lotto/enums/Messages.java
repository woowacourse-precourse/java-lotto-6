package lotto.enums;

public enum Messages {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNUMER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUMER_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTERY_STATISTICS("당첨 통계"),
    NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    PRICE_DEVIDE_ERROR_MESSAGE("[ERROR] 1000원 단위로 입력해야 합니다."),
    PURE_INTEGER_ERROR_MESSAGE("[ERROR] 정수 입력이여야 합니다."),
    ;

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

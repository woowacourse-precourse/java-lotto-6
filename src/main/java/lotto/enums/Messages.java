package lotto.enums;

public enum Messages {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNUMER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUMER_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTERY_STATISTICS("당첨 통계"),
    ;

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

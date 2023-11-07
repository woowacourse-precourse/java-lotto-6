package lotto.constant;

public enum MessageConstant {
    BUY_MESSAGE("구입금액을 입력해 주세요."),
    PRIZE_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    PRIZE_STATS_MESSAGE("당첨 통계");

    private final String value;

    MessageConstant(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

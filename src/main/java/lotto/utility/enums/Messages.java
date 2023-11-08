package lotto.utility.enums;

public enum Messages {
    INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("\n%d개를 구매했습니다."),
    INPUT_LOTTO_WINNING_NUUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    THREE_WINNING_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOUR_WINNING_MESSAGE("4개 일치 (50,000원) - %d개"),
    FIVE_WINNING_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    FIVE_WINNING_AND_BONUS_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_WINNING_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
    LOTTO_PROFIT_RATE_MESSAGE("총 수익률은 %s%%입니다.");


    private String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

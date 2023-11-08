package lotto.enums;

public enum Messages {
    PRICE_INPUT_GUIDE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT_GUIDE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_GUIDE("보너스 번호를 입력해 주세요."),
    TICKET_AMOUNT("개를 구매했습니다."),
    RESULT_TITLE("당첨 통계\n---"),
    HIT("개 일치 ("),
    BONUS_HIT("개 일치, 보너스 볼 일치 ("),
    PRICE_TAIL("원) - "),
    AMOUNT("개"),
    RATE_OF_RETURN_HEAD("총 수익률은 "),
    RATE_OF_RETURN_TAIL("%입니다.");

    private final String msg;

    Messages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

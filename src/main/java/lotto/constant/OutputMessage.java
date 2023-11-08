package lotto.constant;

public enum OutputMessage {
    START_MESSAGE("구입금액을 입력해 주세요.")
    , PURCHASE_MESSAGE("개를 구매하셨습니다.")
    , WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요.")
    , BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.")
    , RESULT_MESSAGE("당첨 통계\n---")
    , RESULT_MESSAGE2("개 일치")
    , RESULT_MESSAGE3("원) - ")
    , RESULT_MESSAGE4("개")
    , RESULT_MESSAGE5(", 보너스 볼 일치")
    , BRACKET_START(" (")
    , RATE_MESSAGE("총 수익률은 ")
    , END_MESSAGE("%입니다.\n")
    ;

    private final String message;
    
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

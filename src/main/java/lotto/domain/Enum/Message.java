package lotto.domain.Enum;

public enum Message {
    INPUT_AMOUNT_MESSAGE("구입 금액을 입력해 주세요."),
    INPUT_WINNINGLOTTO("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUMBER("\n보너스 번호를 입력해 주세요."),
    RESULT("\n당첨 통계\n---"),
    RANKING_FIRST("6개 일치 (2,000,000,000원) - "),
    RANKING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANKING_THIRD("5개 일치 (1,500,000원) - "),
    RANKING_FORTH("4개 일치 (50,000원) - "),
    RANKING_FIFTH("3개 일치 (5,000원) - ");
    private final String message;
    Message(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}

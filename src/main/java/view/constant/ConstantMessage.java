package view.constant;

import static view.constant.ConstantMoney.*;

public enum ConstantMessage {
    ASK_MONEY("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BUY_RESULT("개를 구매했습니다."),

    WINNING_RESULT("당첨 통계"),
    THREE_DASH("---"),
    THREE_MATCHES_MONEY("5,000"),
    FOUR_MATCHES_MONEY("50,000"),
    FIVE_MATCHES_MONEY("1,500,000"),
    FIVE_BONUS_MATCHES_MONEY("30,000,000"),
    SIX_MATCHES_MONEY("2,000,000,000"),
    THREE_MATCHES("3개 일치 ("+ THREE_MATCHES_MONEY.getMessage() + "원) - "),
    FOUR_MATCHES("4개 일치 ("+ FOUR_MATCHES_MONEY.getMessage() +"원) - "),
    FIVE_MATCHES("5개 일치 ("+ FIVE_MATCHES_MONEY.getMessage() +"원) - "),
    FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 ("+ FIVE_BONUS_MATCHES_MONEY.getMessage() +"원) - "),
    SIX_MATCHES("6개 일치 ("+ SIX_MATCHES_MONEY.getMessage() +"원) - "),
    EA("개"),
    TOTAL_RETURN("총 수익률은 "),
    IPNIDA("%입니다.");


    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    private static final ConstantMessage[] LottoResult = {
            THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, FIVE_BONUS_MATCHES,SIX_MATCHES
    };

    public static ConstantMessage getLottoResult(int i) {
        return LottoResult[i];
    }

    public String getMessage(){
        return message;
    }

}

package view.constant;

import static view.constant.ConstantMoney.*;

public enum ConstantMessage {
    ASK_MONEY("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BUY_RESULT("개를 구매했습니다."),

    WINNING_RESULT("당첨 통계"),
    THREE_DASH("---"),

    THREE_MATCHES("3개 일치 ("+ THREE_MATCHES_MONEY.getMoney() + "원) - "),
    FOUR_MATCHES("4개 일치 ("+ FOUR_MATCHES_MONEY.getMoney() +") - "),
    FIVE_MATCHES("5개 일치 ("+ FIVE_MATCHES_MONEY.getMoney() +") - "),
    FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 ("+ FIVE_BONUS_MATCHES_MONEY.getMoney() +") - "),
    SIX_MATCHES("6개 일치 ("+ SIX_MATCHES_MONEY.getMoney() +") - "),
    EA("개"),
    TOTAL_RETURN("총 수익률은 "),
    IPNIDA("입니다.");


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

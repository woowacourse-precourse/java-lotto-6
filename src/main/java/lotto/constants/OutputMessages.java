package lotto.constants;

import java.util.function.Function;

public enum OutputMessages {
    INPUT_BUY_AMOUNT(value -> "\n" + value + "개를 구매했습니다."),
    WIN_STATISTICS(value -> "당첨 통계\n---"),
    MATCH_NUMBER(value -> String.format("\n%s개 일치",value)),
    MATCH_BONUS(value -> ", 보너스 볼 일치"),
    MATCH_MONEY(value -> String.format(" (%s원)",value)),
    MATCH_COUNT(value -> String.format(" -%s개",value)),

    PROFIT_RATE(value -> String.format("\n총 수익률은 %s입니다.", value));

    private final Function<String, String> expression;

    OutputMessages(Function<String, String> message) {
        this.expression = message;
    }

    public String makeMessage(String value){
        return expression.apply(value);
    }
}

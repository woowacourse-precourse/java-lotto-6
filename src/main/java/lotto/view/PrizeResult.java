package lotto.view;

import java.text.DecimalFormat;

public enum PrizeResult {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);


    private final int same, money;

    private DecimalFormat df = new DecimalFormat("###,###");

    private final String RESULT_COUNT = "개 일치";
    private final String RESULT_MONEY_START = " (";
    private final String RESULT_MONEY_END = "원) - ";
    private final String RESULT_END = "개";
    private final String RESULT_BONUS = ", 보너스 볼 일치";


    PrizeResult(int same, int money) {
        this.same = same;
        this.money = money;
    }

    public String getMessage(int cnt) {
        StringBuilder message = new StringBuilder(same + RESULT_COUNT);
        if (this == FIVE_BONUS) {
            message.append(RESULT_BONUS);
        }
        message.append(RESULT_MONEY_START).append(df.format(money)).append(RESULT_MONEY_END);
        message.append(cnt + RESULT_END);
        return message.toString();
    }

    public int getSame() {
        return same;
    }

    public int getMoney() {
        return money;
    }
}

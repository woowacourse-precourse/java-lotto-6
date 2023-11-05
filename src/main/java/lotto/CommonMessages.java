package lotto;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public enum CommonMessages {

    // Input Messages
    PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    WINNING_AMOUNT_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n" + "---"),
    PROFIT_RATE("총 수익률은 ");

    private final String message;

    CommonMessages(String message) {

        this.message = message;
    }

    public String getMessage() {

        return this.message;
    }

    public String getMessage(double profit) {

        DecimalFormat df = new DecimalFormat("###,###.0");
        double resultProfit = Math.round(profit*100.0*100.0) / 100.0;
        String profitResult = df.format(resultProfit);
        return this.message + profitResult + "%입니다.";
    }
}

package lotto.util.message;

import lotto.model.constant.LottoPrizeConstant;

public enum ResultMessage {

    RESULT_HEADER("\n당첨통계\n"),
    RESULT_HEADER_LINE("---\n"),
    NORMAL_DRAW_RESULT("%d개 일치 (%s원) - %d개%n"),
    SECOND_DRAW_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n"),
    RETURN_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getReturnRate(double returnRate) {
        return String.format(RETURN_RATE.message, returnRate);
    }

    public String normalDrawResult(LottoPrizeConstant prize, int matchedCount) {
        String formattedMoney = String.format("%,d", prize.getPrize());
        return String.format(NORMAL_DRAW_RESULT.message, prize.getStandard(), formattedMoney, matchedCount);
    }

    public String secondDrawResult(LottoPrizeConstant prize, int matchedCount) {
        String formattedMoney = String.format("%,d", prize.getPrize());
        return String.format(SECOND_DRAW_RESULT.message, prize.getStandard(), formattedMoney, matchedCount);
    }
}

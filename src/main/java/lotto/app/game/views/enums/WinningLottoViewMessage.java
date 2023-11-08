package lotto.app.game.views.enums;

import java.text.DecimalFormat;

public enum WinningLottoViewMessage {

    ASK_WINNING_NUMBERS("""
                        
            당첨 번호를 입력해 주세요"""),
    ASK_BONUS_NUMBER("""
                        
            보너스 번호를 입력해 주세요."""),
    ANNOUNCE_WINNING_STATISTICS("""
                        
            당첨 통계
            ---"""),
    PRE_CALCULATION_PROFIT("총 수익률은 "),
    POST_CALCULATION_PROFIT("%입니다."),
    EXCEPTION_OUT_OF_RANGE("번호는 1부터 45까지의 숫자 중에서 선택할 수 있습니다."),
    EXCEPTION_NOT_SIX("당첨 번호는 여섯자리 숫자입니다."),
    EXCEPTION_DUPLICATED("당첨 번호는 중복될 수 없습니다."),
    DELIMITER_NUMBERS(","),
    ;

    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int COUNT_OF_NUMBERS = 6;

    private static final String PROFIT_PATTERN = "#,##0.0";

    private final String message;

    WinningLottoViewMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public static String calculationProfit(double totalPrizeMoney, int purchaseAmount) {
        return PRE_CALCULATION_PROFIT.get()
                + roundProfitFromTwoDecimalPlaces(totalPrizeMoney, purchaseAmount)
                + POST_CALCULATION_PROFIT.get();
    }

    private static String roundProfitFromTwoDecimalPlaces(double totalPrizeMoney, int purchaseAmount) {
        return new DecimalFormat(PROFIT_PATTERN)
                .format((double) Math.round((totalPrizeMoney / purchaseAmount) * 1_000) / 10);
    }

}

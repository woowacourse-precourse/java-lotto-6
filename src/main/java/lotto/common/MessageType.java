package lotto.common;

import java.text.DecimalFormat;

/**
 * @Enum : 출력 메시지 타입 열거형
 */
public enum MessageType {

    ASK_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    PURCHASED_LOTTO_FORMAT("%d개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    ADVANCE("-"),
    WINNING_STATISTICS_FORMAT("%d개 일치 (%s원) - %d개"),
    WINNING_STATISTICS_BONUS_FORMAT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    WINNING_RATE_OF_RETURN_FORMAT("총 수익률은 %s%%입니다."),
    ;
    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getEaMessage(int ea) {
        return String.format(PURCHASED_LOTTO_FORMAT.getMessage(), ea);
    }

    public static String getStatisticsMessage(int matchCount, int reward, int ea, boolean isLottoSecondRank) {
        String messageFormat = WINNING_STATISTICS_FORMAT.getMessage();
        if (isLottoSecondRank) {
            messageFormat = WINNING_STATISTICS_BONUS_FORMAT.getMessage();
        }
        return String.format(
                messageFormat,
                matchCount,
                String.format("%,d", reward),
                ea
        );
    }

    public static String getRateOfReturnMessage(double rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedRate = decimalFormat.format(rateOfReturn);
        return String.format(WINNING_RATE_OF_RETURN_FORMAT.getMessage(), formattedRate);
    }
}

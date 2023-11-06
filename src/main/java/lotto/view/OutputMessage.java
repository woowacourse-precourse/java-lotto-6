package lotto.view;

import java.text.DecimalFormat;
import lotto.constant.Prize;

public enum OutputMessage {
    REQUEST_MONEY_TO_BUY("구입금액을 입력해 주세요."),
    BUY_LOTTO_RESULT("%d개를 구매했습니다.\n"),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_GRADE_RESULT(
            "3개 일치 (" + getFormattedNumber(Prize.THREE_MATCH) + "원) - %d개\n"
                    + "4개 일치 (" + getFormattedNumber(Prize.FOUR_MATCH) + "원) - %d개\n"
                    + "5개 일치 (" + getFormattedNumber(Prize.FIVE_MATCH) + "원) - %d개\n"
                    + "5개 일치, 보너스 볼 일치 (" + getFormattedNumber(Prize.FIVE_AND_BONUS_MATCH) + "원) - %d개\n"
                    + "6개 일치 (" + getFormattedNumber(Prize.SIX_MATCH) + "원) - %d개\n"),
    RATE_OF_RETURN("총 수익률은 %s%%입니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }

    // 숫자를 3자리 마다 ',' 찍어 주는 함수
    private static String getFormattedNumber(Prize prize) {
        return DecimalFormat.getInstance().format(prize.getPrice());
    }
}

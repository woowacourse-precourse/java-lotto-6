package lotto.enums;

import lotto.domain.Lotto;
import lotto.utils.Formatter;

public enum OutputMessageEnum {

    OUTPUT_PURCHASE_AMOUNT_MESSAGE("%d개를 구입했습니다."),
    OUTPUT_LOTTO_MESSAGE("%s"),
    OUTPUT_RESULT_START_MESSAGE("당첨 통계"),
    OUTPUT_THREE_SAME_MESSAGE("3개 일치 (%s원) - %d개"),
    OUTPUT_FOUR_SAME_MESSAGE("4개 일치 (%s원) - %d개"),
    OUTPUT_FIVE_SAME_MESSAGE("5개 일치 (%s원) - %d개"),
    OUTPUT_FIVE_AND_BONUS_SAME_MESSAGE("5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_SIX_SAME_MESSAGE("6개 일치 (%s원) - %d개"),
    OUTPUT_RESULT_END_MESSAGE("총 수익률은 %.1f%%입니다."),
    OUTPUT_LINE("---");

    private String message;

    OutputMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int value) {
        return String.format(this.message, value);
    }

    public String getMessage(int prize, int count) {
        String pizeParsed = Formatter.formatToDecimal(prize);
        return String.format(this.message, pizeParsed, count);
    }

    public String getMessage(Lotto lotto) {
        return lotto.toString();
    }
}

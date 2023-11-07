package lotto.global.enums;

public final class GuideMessage {

    public final static String INPUT_PAYMENT_COMMAND = "구입금액을 입력해 주세요.";
    public final static String INPUT_WINNING_NUMBER_COMMAND = "당첨 번호를 입력해 주세요.";
    public final static String INPUT_BONUS_NUMBER_COMMAND = "보너스 번호를 입력해 주세요.";

    public final static String PAYMENT_STATUS = "%d개를 구매했습니다.";
    public final static String OUTPUT_RATE_OF_PROFIT = "총 수익률은 %.1f%%입니다.";
    public final static String STATICS_OF_WINNING = "\n당첨 통계";
    public final static String LOTTO_WINNING_RESULT = "3개 일치 (5,000원) - %d개\n"
                            + "4개 일치 (50,000원) - %d개\n"
                            + "5개 일치 (1,500,000원) - %d개\n"
                            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                            + "6개 일치 (2,000,000,000원) - %d개\n";
}

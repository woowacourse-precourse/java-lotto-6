package lotto.view.constant;

public class viewMessage {

    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.\n";
    public static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.\n";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.\n";

    public static final String OUTPUT_PURCHASE_RESULT = "\n%d개를 구매했습니다.\n";
    public static final String OUTPUT_WINNING_STATISTICS_INTRO = "\n당첨 통계\n---\n";
    public static final String OUTPUT_WINNING_STATISTICS_RESULT =
            "3개 일치 (5,000원) - %d개\n" +
                    "4개 일치 (50,000원) - %d개\n" +
                    "5개 일치 (1,500,000원) - %d개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                    "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
}

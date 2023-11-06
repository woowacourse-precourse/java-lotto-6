package lotto.message;

public class ViewMessage {
    public static final String INPUT_PURCHASE_MONEY = "구입 금액을 입력해 주세요.";
    public static final String INPUT_ANSWER_LOTTO = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_RESULT_HEADER = "당첨 통계\n" + "---";
    public static final String OUTPUT_PROFIT_RATE = "총 수익률은 %s%%입니다.";

    private ViewMessage() {
        // 불필요한 인스턴스 생성 방지
    }
}

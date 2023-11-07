package constants;

public enum ConstantStringManager {
    LOTTO_PRICE_INPUT_NOTIFY("구입금액을 입력해 주세요"),
    LOTTO_NUMBER_NOTIFY("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_INPUT_NOTIFY("당첨 번호를 입력해 주세요"),
    BONUS_NUMBER_INPUT_NOTIFY("보너스 번호를 입력해 주세요"),
    WINNING_STATICS_NOTIFY("당첨 통계\n___\n"),
    LOTTO_SAME_THREE("3개 일치 (5,000원) - %d개\n"),
    LOTTO_SAME_FOUR("4개 일치 (50,000원) - %d개\n"),
    LOTTO_SAME_FIVE("5개 일치 (1,500,000원) - %d개\n"),
    LOTTO_SAME_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    LOTTO_SAME_SIX("6개 일치 (2,000,000,000원) - %d개\n"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.\n"),
    LIST_START_MARK("["),
    LIST_END_MARK("]\n"),
    LIST_SPLIT_MARK(", "),
    SPLIT_TARGET(",");

    private final String message;

    ConstantStringManager(String message) {
        this.message = message;
    } //enum 타입에서 string 타입으로 변환

    public String getMessage() {
        return message;
    }
}

package lotto.common;

import lotto.Lotto;

public enum Announcement {

    INPUT_AMOUNT("구입금액을 입력해 주세요.\n"),
    PURCHASE_LOTTOS("개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n"),
    WINNING_STATS("당첨 통계\n---\n"),

    RANK_ONE("6개 일치 (2,000,000,000원)"),
    RANK_TWO("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_THREE("5개 일치 (1,500,000원)"),
    RANK_FOUR("4개 일치 (50,000원)"),
    RANK_FIVE("3개 일치 (5,000원)"),
    ;

    private final String script;

    Announcement(String script) {
        this.script = script;
    }

    public String getScript() {
        return this.script;
    }

    public void speak() {
        System.out.print(this.script);
    }

    public void speak(int size) {
        System.out.print(size + this.script);
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printTotalPrizeMoneyRate(double totalPrizeMoney, double purchasePrize) {
        System.out.println("총 수익률은 " + totalPrizeMoney / purchasePrize * 100 + "%입니다.");
    }
}

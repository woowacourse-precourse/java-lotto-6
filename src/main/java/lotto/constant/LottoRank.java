package lotto.constant;

public enum LottoRank {
    FIRST_PRIZE(2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(1500000, "5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(50000, "4개 일치 (50,000원) - "),
    FIFTH_PRIZE(5000, "3개 일치 (5,000원) - "),
    NO_PRIZE(0, "");

    private static final String SUFFIX_OF_MESSAGE = "개";

    private final long money;
    private final String prefixOfMessage;

    private LottoRank(long money, String prefixOfMessage) {
        this.money = money;
        this.prefixOfMessage = prefixOfMessage;
    }

    public long getMoney() {
        return money;
    }

    public String getMessageWith(int counts) {
        return prefixOfMessage + counts + SUFFIX_OF_MESSAGE;
    }

    public static LottoRank getRank(int winningInLotto, boolean bonusInLotto) {
        if (winningInLotto == 6) {
            return LottoRank.FIRST_PRIZE;
        } else if (winningInLotto == 5 && bonusInLotto) {
            return LottoRank.SECOND_PRIZE;
        } else if (winningInLotto == 5) {
            return LottoRank.THIRD_PRIZE;
        } else if (winningInLotto == 4) {
            return LottoRank.FOURTH_PRIZE;
        } else if (winningInLotto == 3) {
            return LottoRank.FIFTH_PRIZE;
        }
        return LottoRank.NO_PRIZE;
    }
}

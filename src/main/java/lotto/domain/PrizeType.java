package lotto.domain;

public enum PrizeType {
    MATCH3(5000, 3, "3개 일치 (%s원) - %d개\n"),
    MATCH4(50000, 4, "4개 일치 (%s원) - %d개\n"),
    MATCH5(1500000, 5, "5개 일치 (%s원) - %d개\n"),
    MATCH5_WITH_BONUS(30000000, 8, "5개 일치, 보너스 볼 일치 (%s원) - %d개\n"), //임의의 숫자 초기화
    MATCH6(2000000000, 6, "6개 일치 (%s원) - %d개\n"),
    NOT_APPLICABLE(0, 0, "%s %d");

    private final int prize;
    private final int matchCount;
    private final String message;

    PrizeType(int prize, int matchCount, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.message = message;
    }

    public static String getMessage(PrizeType prizeType, int count) {
        return prizeType.message.formatted(getPrizeMoneyWithComma(prizeType), count);
    }

    private static String getPrizeMoneyWithComma(PrizeType prizeType) {
        String prizeMoney = String.valueOf(prizeType.getPrize());

        StringBuilder sb = new StringBuilder();
        sb.append(prizeMoney.charAt(0));

        for (int i = 1; i < prizeMoney.length(); i++) {
            if ((prizeMoney.length() - i) % 3 == 0) {
                sb.append(',');
            }
            sb.append(prizeMoney.charAt(i));
        }

        return sb.toString();
    }

    public int getPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static PrizeType valueOfMatchCount(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch == true) {
            return MATCH5_WITH_BONUS;
        }

        for (PrizeType prizeType : values()) {
            if (prizeType.getMatchCount() == matchCount) {
                return prizeType;
            }
        }

        return NOT_APPLICABLE;
    }
}

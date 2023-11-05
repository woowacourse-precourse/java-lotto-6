package lotto.domain;

import java.util.List;

public enum MatchNumber {
    FIRST("6개 일치", 6, false, "(2,000,000,000원)", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 5, true, "(30,000,000원)", 30000000),
    THIRD("5개 일치", 5, false, "(1,500,000원)", 1500000),
    FOURTH("4개 일치", 4, false, "(50,000원)", 50000),
    FIFTH("3개 일치", 3, false, "(5,000원)", 5000),
    NOTHING("", 0, false, "", 0);

    private String resultMessage;
    private int matchNumber;
    private boolean isBonusMatch;
    private String moneyMessage;
    private int money;

    private static final List<MatchNumber> bonusMatchNumbers = List.of(FIRST, SECOND, FOURTH, FIFTH);
    private static final List<MatchNumber> bonusNotMatchNumbers = List.of(FIRST, THIRD, FOURTH, FIFTH);

    public int getMoney() {
        return money;
    }

    MatchNumber(String resultMessage,
                int matchNumber,
                boolean isBonusMatch,
                String moneyMessage,
                int money) {
        this.resultMessage = resultMessage;
        this.matchNumber = matchNumber;
        this.isBonusMatch = isBonusMatch;
        this.moneyMessage = moneyMessage;
        this.money = money;
    }

    public static MatchNumber findByMatchCountAndBonus(int count, boolean isBonusMatch) {
        if (isBonusMatch) {
            return bonusMatchNumbers.stream()
                    .filter(match ->
                            match.matchNumber == count)
                    .findFirst()
                    .orElse(NOTHING);
        }
        List<MatchNumber> matchNumbers = List.of(FIRST, THIRD, FOURTH, FIFTH);
        return bonusNotMatchNumbers.stream()
                .filter(match ->
                        match.matchNumber == count)
                .findFirst()
                .orElse(NOTHING);
    }

}

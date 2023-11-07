package lotto.rule;

import java.util.Arrays;

public enum LottoWinningRule {
    RANK_ONE(6, false, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    RANK_TWO(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RANK_THREE(5, false, 1500000, "5개 일치 (1,500,000원) - %d개"),
    RANK_FOUR(4, false, 50000, "4개 일치 (50,000원) - %d개"),
    RANK_FIVE(3, false, 5000, "3개 일치 (5,000원) - %d개"),
    UNRANKED(0, false, 0, "일치하는 볼이 없습니다.");

    private final int matchNumber;
    private final boolean bonusMatch;
    private final int money;
    private final String information;

    LottoWinningRule(int matchNumber, boolean bonusMatch, int money, String information) {
        this.matchNumber = matchNumber;
        this.bonusMatch = bonusMatch;
        this.money = money;
        this.information = information;
    }

    public static LottoWinningRule getRank(int countMatch, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rule -> rule.matchNumber == countMatch && (countMatch != 5 || rule.bonusMatch == bonusMatch))
                .findFirst()
                .orElse(LottoWinningRule.UNRANKED);
    }

    public int getMoney() {
        return money;
    }

    public String getInformation() {
        return information;
    }
}

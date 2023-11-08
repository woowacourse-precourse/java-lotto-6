package lotto.domain;

import java.util.Collections;
import java.util.List;

public enum LottoRank {
    FIRST(4, "6개 일치", 6, false, "(2,000,000,000원)", 2000000000),
    SECOND(3, "5개 일치, 보너스 볼 일치", 5, true, "(30,000,000원)", 30000000),
    THIRD(2, "5개 일치", 5, false, "(1,500,000원)", 1500000),
    FOURTH(1, "4개 일치", 4, false, "(50,000원)", 50000),
    FIFTH(0, "3개 일치", 3, false, "(5,000원)", 5000),
    NOTHING(-1, "", 0, false, "", 0);

    private int listIndex;
    private String resultMessage;
    private int matchNumber;
    private boolean isBonusMatch;
    private String moneyMessage;
    private int money;

    private static final List<LottoRank> BONUS_LOTTO_RANKS = List.of(FIRST, SECOND, FOURTH, FIFTH);
    private static final List<LottoRank> BONUS_NOT_LOTTO_RANKS = List.of(FIRST, THIRD, FOURTH, FIFTH);

    public int getListIndex() {
        return listIndex;
    }

    public int getMoney() {
        return money;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public String getMoneyMessage() {
        return moneyMessage;
    }

    public static List<LottoRank> getMembers() {
        return Collections.unmodifiableList(List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST));
    }

    private LottoRank(int index,
                      String resultMessage,
                      int matchNumber,
                      boolean isBonusMatch,
                      String moneyMessage,
                      int money) {
        this.listIndex = index;
        this.resultMessage = resultMessage;
        this.matchNumber = matchNumber;
        this.isBonusMatch = isBonusMatch;
        this.moneyMessage = moneyMessage;
        this.money = money;
    }

    public static LottoRank findRankByMatchCountAndBonus(int count, boolean isBonusMatch) {
        if (isBonusMatch) {
            return BONUS_LOTTO_RANKS.stream()
                    .filter(match ->
                            match.matchNumber == count)
                    .findFirst()
                    .orElse(NOTHING);
        }
        return BONUS_NOT_LOTTO_RANKS.stream()
                .filter(match ->
                        match.matchNumber == count)
                .findFirst()
                .orElse(NOTHING);
    }

    public static int countMatchNumber(List<LottoRank> lottoRanks, LottoRank match) {
        return (int) lottoRanks.stream().filter(m -> m.getMatchNumber() == match.getMatchNumber()).count();
    }

}

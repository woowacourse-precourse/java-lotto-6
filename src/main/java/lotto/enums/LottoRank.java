package lotto.enums;

import java.util.Comparator;

public enum LottoRank implements Comparable<LottoRank>{
    NONE(0, null),
    THIRD(5000, "3개 일치 (5,000원)"),
    FOURTH(50000, "4개 일치 (50,000원)"),
    FIFTH_WITHOUT_BONUS(1500000, "5개 일치 (1,500,000원)"),
    FIFTH_WITH_BONUS(3000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIXTH(2000000000, "6개 일치 (2,000,000,000원)");
    public int prize;
    public String prizeMsg;

    LottoRank(int prize, String prizeMsg) {
        this.prize = prize;
        this.prizeMsg = prizeMsg;
    }
}

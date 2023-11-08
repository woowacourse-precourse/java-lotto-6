package constant;

import java.util.Arrays;
import util.FormatUtil;

public enum Rank {
    NONE(0, 0, false, 0),
    FIFTH(5, 3, false, 5000),
    FOURTH(4, 4, false, 50000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FIRST(1, 6, false, 2000000000);

    private final int rankCode;
    private final int countOfMatch;
    private final boolean hasBonus;
    private final int price;

    Rank(int rankCode, int countOfMatch, boolean hasBonus, int price) {
        this.rankCode = rankCode;
        this.countOfMatch = countOfMatch;
        this.hasBonus = hasBonus;
        this.price = price;
    }


    public static Rank valueOf(int countOfMatch, boolean hasBonus) {
        if (countOfMatch == 5 && hasBonus) {
            return Rank.SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.equalCount(countOfMatch))
                .findAny()
                .orElse(NONE);
    }

    private boolean equalCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String result = countOfMatch + "개 일치";
        if (this.rankCode == 2) {
            result += ", 보너스 볼 일치";
        }

        return result + " (" + FormatUtil.forWon(price) + ") -";
    }

}


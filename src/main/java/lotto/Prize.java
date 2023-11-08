package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    FIFTH(3, "3개 일치 (5,000원)", "5000", 0),
    FOURTH(4, "4개 일치 (50,000원)", "50000", 0),
    THIRD(5, false, "5개 일치 (1,500,000원)", "1500000", 0),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30000000원)", "30,000,000", 0),
    FIRST(6, "6개 일치 (2,000,000,000원)", "2000000000", 0);

    protected final int matchCount;
    protected final boolean matchBonus;
    protected final String description;
    protected final String cash;
    protected int storNum;

    Prize(int matchCount, String description, String cash, int storNum) {
        this(matchCount, false, description, cash, storNum);
    }

    Prize(int matchCount, boolean matchBonus, String description, String cash, int storNum) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.description = description;
        this.cash = cash;
        this.storNum = storNum;
    }

    public void checkLotto(Lotto lotto, List<Integer> prizeNum, int bonusNum) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (prizeNum.contains(number)) {
                count++;
            }
        }

        if (count == matchCount && matchCount == 5 && prizeNum.contains(bonusNum)) {
            storNum++;
        } else if (count == matchCount) {
            storNum++;
        }
    }
}
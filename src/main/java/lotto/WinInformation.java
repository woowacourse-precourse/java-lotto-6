package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinInformation {

    ZERO("unRank", 0, 0L),
    ONE("unRank", 1, 0L),
    TWO("unRank", 2, 0L),
    THREE("3개 일치 (5,000원) - ", 3, 5000L),
    FOUR("4개 일치 (50,000원) - ", 4, 50000L),
    FIVE_NO_BONUS("5개 일치 (1,500,000원) - ", 5, 1500000L),
    FIVE_YES_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 6, 30000000L),
    SIX("6개 일치 (2,000,000,000원) - ", 6, 2000000000L);

    private String rankResult;
    private int matchCount;
    private long winMoney;

    WinInformation(String rankResult, int matchCount, long winMoney) {
        this.rankResult = rankResult;
        this.matchCount = matchCount;
        this.winMoney = winMoney;
    }

    public String getRankResult() {
        return rankResult;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinMoney() {
        return winMoney;
    }
}

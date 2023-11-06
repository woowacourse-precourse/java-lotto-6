package lotto.Constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottosConstants {
    SIX_MATCH (6, 2_000_000_000),
    FIVE_MATCH_BONUS (5, 30_000_000),
    FIVE_MATCH (5, 1_500_000),
    FOUR_MATCH (4, 50_000),
    THREE_MATCH (3, 5_000),
    NONE (2, 0);

    private final int matchNumber;
    private final int prizeMoney;

    LottosConstants(int matchNumber, int prizeMoney){
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }
}

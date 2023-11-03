package lotto.utils;

import static lotto.enums.PrizeRank.FIFTH;
import static lotto.enums.PrizeRank.FIRST;
import static lotto.enums.PrizeRank.FOURTH;
import static lotto.enums.PrizeRank.SECOND;
import static lotto.enums.PrizeRank.THIRD;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static int moneyToCount(String money) {
        return Integer.parseInt(money) / 1000;
    }

    public static List<Integer> stringToIntArray(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int rankToPrize(int rank) {
        return switch (rank) {
            case 5 -> FIFTH.prize();
            case 4 -> FOURTH.prize();
            case 3 -> THIRD.prize();
            case 2 -> SECOND.prize();
            case 1 -> FIRST.prize();
            default -> 0;
        };
    }

    public static int rankToSameNumbers(int rank) {
        return switch (rank) {
            case 5 -> FIFTH.matchCondition();
            case 4 -> FOURTH.matchCondition();
            case 3 -> THIRD.matchCondition();
            case 2 -> SECOND.matchCondition();
            case 1 -> FIRST.matchCondition();
            default -> 0;
        };
    }
}

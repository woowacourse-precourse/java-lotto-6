package lotto.utils;

import static lotto.enums.NumberCondition.MONEY_UNIT;
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
        return Integer.parseInt(money) / MONEY_UNIT.number();
    }

    public static int countToMoney(int count) {
        return count * MONEY_UNIT.number();
    }

    public static List<Integer> stringToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int rankToPrizeMoney(int rank) {
        if (rank == 5) {
            return FIFTH.prizeMoney();
        }
        if (rank == 4) {
            return FOURTH.prizeMoney();
        }
        if (rank == 3) {
            return THIRD.prizeMoney();
        }
        if (rank == 2) {
            return SECOND.prizeMoney();
        }
        if (rank == 1) {
            return FIRST.prizeMoney();
        }
        return 0;
    }

    public static int rankToSameNumbers(int rank) {
        if (rank == 5) {
            return FIFTH.matchCondition();
        }
        if (rank == 4) {
            return FOURTH.matchCondition();
        }
        if (rank == 3) {
            return THIRD.matchCondition();
        }
        if (rank == 2) {
            return SECOND.matchCondition();
        }
        if (rank == 1) {
            return FIRST.matchCondition();
        }
        return 0;
    }
}

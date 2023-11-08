package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Ranks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static lotto.constants.Lottoes.*;

public class NumberUtil {
    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                START_NUMBER.getValue(),
                END_NUMBER.getValue(),
                MAX_NUMBER.getValue()
        );
    }

    public static BigDecimal getRate(int inputPrice, List<Ranks> ranks) {
        long winningPrice = ranks
                .stream()
                .mapToLong(Ranks::getMoney)
                .sum();

        return BigDecimal.valueOf(winningPrice / inputPrice)
                .multiply(new BigDecimal("100"))
                .setScale(1, RoundingMode.HALF_UP);
    }
}

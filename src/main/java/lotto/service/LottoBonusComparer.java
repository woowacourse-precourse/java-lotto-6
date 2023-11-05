package lotto.service;

import java.util.List;
import lotto.domain.Bonus;

public class LottoBonusComparer {
    public static boolean compare(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}

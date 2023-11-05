package lotto.service;

import java.util.List;

public class LottoBonusComparer {
    public static boolean compare(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}

package lotto.controller.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandNumber {
    private static final int start = 1;
    private static final int end = 45;
    private static final int count = 6;

    public static List<Integer> makeRandNumber() {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static List<Integer> makeUniqueNumber() {
        List<Integer> numbers = new ArrayList<>();
        while(true) {
            numbers = makeRandNumber();
            if (checkRandDuplicate(numbers)) {
                break;
            }

        }
        return numbers;
    }

    public static boolean checkRandDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            return false;
        }
        return true;
    }

}

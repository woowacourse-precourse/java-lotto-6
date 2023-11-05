package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandNumber {
    public static List<Integer> makeRandNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public static List<Integer> makeUniqueNumber() {
        List<Integer> numbers = new ArrayList<>();
        while(true) {
            numbers = makeRandNumber();
            if (checkDuplicate(numbers)) {
                break;
            }

        }
        return numbers;
    }

    public static boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            return false;
        }
        return true;
    }

}

package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandNumber {
    public static List<Integer> makeRandNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public static List<Integer> checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() == numbers.size()) {
            return numbers;
        }
        return checkDuplicate(makeRandNumber());
    }

}

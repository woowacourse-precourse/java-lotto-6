package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> makeUniQueRandomNumbers(int minNum, int maxNum, int size) {
        List<Integer> uniqueRandomNumbers = new ArrayList<>();
        if (maxNum - minNum + 1 < size) {
            return null;
        }

        while (uniqueRandomNumbers.size() < size) {
            int randomNum = pickRandomNumber(minNum, maxNum);
            if (isUniqueNumber(randomNum, uniqueRandomNumbers)) {
                uniqueRandomNumbers.add(randomNum);
            }
        }
        return uniqueRandomNumbers;
    }

    private static boolean isUniqueNumber(int randomNum, List<Integer> uniqueRandomNumbers) {
        return !uniqueRandomNumbers.contains(randomNum);
    }

    private static int pickRandomNumber(int minNum, int maxNum) {
        return Randoms.pickNumberInRange(minNum, maxNum);
    }
}

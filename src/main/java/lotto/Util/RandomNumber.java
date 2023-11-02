package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE , MAX_NUMBER_RANGE);
            if (numbers.contains(randomNumber)) continue;
            numbers.add(randomNumber);
        }
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}

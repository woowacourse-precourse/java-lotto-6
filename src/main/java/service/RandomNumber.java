package service;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 45;
    private static int SELECT_NUMBER = 6;

    private RandomNumber() {
    }

    public static Lotto getRandomNumber() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SELECT_NUMBER));
        sort(numbers);
        return new Lotto(numbers);
    }

}

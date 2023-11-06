package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import java.util.List;

public class RandomNumber {
    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 45;
    private static int COUNT_NUMBER = 6;

    public static Lotto getRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
        return new Lotto(numbers);
    }

}

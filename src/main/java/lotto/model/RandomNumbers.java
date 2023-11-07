package lotto.model;

import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    public List<Integer> getRandomNumbers(){
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE);
//        sortNumbers(numbers);
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers){
        System.out.println(numbers);
        Collections.sort(numbers);
    }
}

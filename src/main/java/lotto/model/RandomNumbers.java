package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    public List<Integer> getRandomNumbers(){
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE);
        List<Integer> sortedNumbers = sortNumbers(numbers);
        return sortedNumbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumber {

    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 45;
    private final static int COUNT = 6;
    private List<Integer> randomNumbers;

    public List<Integer> randomNumbers() {
        this.randomNumbers = generate();
        return sort(this.randomNumbers);
    }

    private List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                COUNT);

    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return randomNumbers;
    }

}





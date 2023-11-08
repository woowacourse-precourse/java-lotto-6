package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Lotto(){
        this.numbers = randomNumbers();
    }

    private List<Integer> randomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public String myLotto(){
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers.toString();
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}

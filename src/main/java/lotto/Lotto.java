package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = validationLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다.");
        }
    }

    private List<Integer> validationLotto(List<Integer> numbers) {
        Set<Integer> buf = new HashSet<>();

        for (Integer i : numbers) {
            buf.add(i);
        }

        if(buf.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }

        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return mutableNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
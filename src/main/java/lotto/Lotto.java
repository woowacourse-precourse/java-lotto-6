package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean containsAll(Lotto lotto) {
        return this.numbers.containsAll(lotto.numbers);
    }

    public boolean contain(int number){
        return this.numbers.contains(number);
    }

    public int returnNumber(int index){
        return this.numbers.get(index);
    }

    private void checkDuplicateNumber(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size()!=numberSet.size()){
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
}

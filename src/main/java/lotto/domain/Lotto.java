package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateSame(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private List<Integer> validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        return numbers;
    }

    // TODO: 추가 기능 구현

    // 중복 로또번호 있는지 확인
    public void validateSame(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
            }
            uniqueNumbers.add(number);
        }
    }

    public void validateRange(List<Integer> numbers){
        for(int number : numbers){
           if(number < 1 || number > 45){
               throw new IllegalArgumentException("로또 번호의 범위는 1~45입니다.");
           }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}

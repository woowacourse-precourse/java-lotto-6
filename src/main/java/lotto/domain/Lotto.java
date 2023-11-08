package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    /**
     * 1. 로또 번호 리스트 필드에 값을 저장하기 전에 검증을 진행하고 저장함
     */
    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateSame(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }


    /**
     * 로또번호가 6개인지 검증
     */
    private List<Integer> validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        return numbers;
    }

    // TODO: 추가 기능 구현

    /**
     * 중복된 로또 번호가 있는지 검증
     */
    public void validateSame(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
            }
            uniqueNumbers.add(number);
        }
    }

    /**
     * 로또 번호가 범위 내(1~45)에 있는지 검증
     */
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

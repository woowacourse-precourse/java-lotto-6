package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        validateNumRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 유효하지 않습니다.");
        }
    }

    private void duplicate(List<Integer> numbers){
        HashSet<Integer> findDuplicate = new HashSet<>();
        for(Integer x : numbers){
            if(!findDuplicate.add(x)){
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }
    }

    private void validateNumRange(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}

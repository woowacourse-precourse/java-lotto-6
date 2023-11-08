package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers){
        Set<Integer> nonDupliecateNumber = new HashSet<>(numbers);
        if(nonDupliecateNumber.size() != 6){
            throw new IllegalArgumentException("[ERROR]로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateRange(List<Integer> numbers){
        for(int matchNumber =0;matchNumber < numbers.size();matchNumber++){
            if(numbers.get(matchNumber) > 45 || numbers.get(matchNumber) < 1){
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45 사이 입니다.");
            }
        }
    }

}

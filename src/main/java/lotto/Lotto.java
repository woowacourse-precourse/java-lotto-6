package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 여섯개의 숫자로 구성되어야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        if(distinctNumberCount != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또에는 중복되는 숫자가 있을 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int number : numbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1부터 45까지 입니다.");
            }
        }
    }

    private void sort(){
        Collections.sort(numbers);
    }
}

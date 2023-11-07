package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numericRange(numbers);
        hasDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 1~45까지 중 6자리를 입력해주세요");
        }

    }

    // TODO: 추가 기능 구현

    public void numericRange(List<Integer> numbers){ // 번호 입력시 범위 내에서만 입력했는지 검증
        for(Integer number : numbers){
            if(number <= 0 || number > 45){
                throw new IllegalArgumentException("[ERROR] 1~45까지 중 6자리를 입력해주세요");
            }
        }
    } // numericRange

    public boolean hasDuplicateNumbers(List<Integer> numbers){ // 입력한 6자리 숫자 중 중복된 값이 있다면 예외발생
        Set<Integer> numberSet = new HashSet<>();
        for(Integer number : numbers){
            if(!numberSet.add(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다. 다시 시도하세요.");
            }
        }
        return true;
    } // hasDuplicateNumbers

    public List<Integer> getNumbers() {
        return numbers;
    } // getNumbers
}

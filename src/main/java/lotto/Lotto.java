package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    public Lotto() {
        this.numbers = new ArrayList<>();
    }
    
    
    void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자만 가능합니다.");
        }
        validateLottoNumbers(numbers);
        checkDuplicateNumbers(numbers);
        
    }
    
    private void validateLottoNumbers(List<Integer> numbers) {
        for(int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    
    private void checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet  = new HashSet<>();

        for (int number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
            }
        }
    }

    
}

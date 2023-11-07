package lotto;

import java.util.ArrayList;
import java.util.List;

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
        
        for(int number : numbers) {
            
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            for(int j = 0; j < i; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
                }
            }
        }
    }

}

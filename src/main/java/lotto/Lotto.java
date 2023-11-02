package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개로 이루어져 있습니다.");
        }
        for(int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        for(int i = 0; i < numbers.size(); i++){
            if (numbers.contains(numbers.get(i))){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 있으면 안됩니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}

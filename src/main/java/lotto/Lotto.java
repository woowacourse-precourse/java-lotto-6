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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(!isRightRangeNum(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private boolean isRightRangeNum(List<Integer> numbers){
        for(Integer num:numbers){
            if(num>45||num<1){
                return false;
            }
        }
        return true;
    }

    // TODO: 추가 기능 구현
}

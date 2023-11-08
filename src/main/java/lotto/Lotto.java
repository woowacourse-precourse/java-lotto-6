package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLotto(){
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            System.out.println("[ERROR] 중복된 요소가 있습니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 숫자 여섯개를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        for(Object object : numbers) {
            if( (int) object > 45 || (int) object <0) {
                System.out.println("[ERROR] 숫자는 1~45 사이의 숫자여야합니다. 다시 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}

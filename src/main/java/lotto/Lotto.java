package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(isOutOfRangeNum(numbers)){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(isOverlapNum(numbers)){
            System.out.println("[ERROR] 로또 번호는 중복되면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }
    private boolean isOutOfRangeNum(List<Integer> numbers){
        for(Integer num:numbers){
            if(num>45||num<1){
                return true;
            }
        }
        return false;
    }
    private boolean isOverlapNum(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        return numbers.size() != numSet.size();
    }
    public void printLotto(){
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}

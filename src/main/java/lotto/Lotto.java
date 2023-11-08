package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate_range(numbers);
        validate_duplicate(numbers);
        this.numbers = numbers;
    }
    
    // 6개의 수인지 validate
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.print("[ERROR] 로또 번호는 6개의 정수여야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }

    // 1~45 수인지 validate
    private void validate_range(List<Integer> numbers) {
        for (Integer num : numbers){
            range_check(num);
        }
    }
    public static void range_check(int num){       
        if (num < 1 || num > 45){
            System.out.print("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }
    
    // 중복 숫자가 있는지 체크
    private void validate_duplicate(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            System.out.print("[ERROR] 로또 번호에 중복 값이 없어야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }

    // private field getter
    public List<Integer> getNumbers() {
        return numbers;
    }


}

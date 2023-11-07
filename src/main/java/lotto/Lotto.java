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

    private void validate(List<Integer> numbers) {
        // 로또 번호가 6개인지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 무조건 6개여야 합니다.");
        }

        // 로또 번호가 모두 [1, 45] 구간에 있는지 확인
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }

        // 로또 번호가 중복되는지 확인
        Set<Integer> unique_numbers = new HashSet<>();
        for(Integer number : numbers){
            if(unique_numbers.contains(number)){
                throw new IllegalArgumentException("6개의 번호들은 서로 중복될 수 없습니다.");
            }
            unique_numbers.add(number);
        }
    }

    // TODO: 추가 기능 구현
    public void printNumbers(){
        System.out.println(numbers);
    }

}

package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        //검증과정
        validate(numbers);
        duplicate(numbers);
        overNumber(numbers);
        lowNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers){
        HashSet<Integer> duplicate = new HashSet<>();

        for(int i = 0; i < numbers.size(); i++){
            duplicate.add(numbers.get(i));
        }

        if(duplicate.size() != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자여야합니다.");
        }

    }

    private void overNumber(List<Integer> numbers){

        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void lowNumber(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }


}
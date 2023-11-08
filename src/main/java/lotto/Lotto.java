package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    // 6개의 숫자 입력받기 6자여야하며 중복된 수 불가,1에서 45사이
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요");
        }
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)>45||numbers.get(i)<1){
                throw new IllegalArgumentException("[ERROR] 1과 45사이의 수를 입력하세요");
            }
        }
    }
}

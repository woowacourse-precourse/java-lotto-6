package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    //클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> basket = new ArrayList<>();
        for(Integer number : numbers){
            if(basket.contains(number)){
                throw new IllegalArgumentException();
            }
            basket.add(number);
        }
    }



}

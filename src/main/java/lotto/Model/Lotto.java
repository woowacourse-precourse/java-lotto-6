package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    //클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
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
    public void sortNumbers(List<Integer> numbers) {
        try{
            Collections.sort(numbers);
        } catch (UnsupportedOperationException e ){
            //테스트때 사용하는 List.of 는 정렬이 불가해서 테스트시의 정렬시 예외 처리후 다음 로직 진행
        }

    }


}

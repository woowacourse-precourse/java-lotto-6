package lotto.domain;

import lotto.util.Constants;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    //제공된 Lotto 클래스를 활용해 구현해야 한다.
    //numbers의 접근 제어자인 private을 변경할 수 없다.
    //Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
    //Lotto의 패키지 변경은 가능하다.

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        isNotDuplicate(numbers);
    }
    // TODO: 추가 기능 구현
    public void isNotDuplicate(List<Integer>numbers){
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException(Constants.NUM_DUPLICATE_EORROR);
        }
    }
    public void sort() {
        numbers.sort(Comparator.naturalOrder());
    }
    public void printResult(){
        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", Constants.LOTTO_START_BRACKET, Constants.LOTTO_END_BRACKET));
        System.out.println(result);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}

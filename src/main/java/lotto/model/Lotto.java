package lotto.model; //패키지 변경은 가능


import static lotto.util.NumbersValidator.checkDuplicate;
import static lotto.util.NumbersValidator.checkElementsInRange;
import static lotto.util.NumbersValidator.validate;

import java.util.List;


public class Lotto { //로또 번호를 오름차순으로 정렬

    private final List<Integer> numbers; //접근제어자 변경 불가능

    //필드(인스턴스 변수) 추가 불가능
    public Lotto(List<Integer> numbers) { //생성자에 추가 기능 구현 가능
        validate(numbers);
        checkDuplicate(numbers);
        checkElementsInRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}

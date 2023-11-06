package lotto.domain;

import lotto.validator.system.LottoValidator;
import lotto.validator.system.SystemValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//제공된 Lotto 클래스를 활용해 구현해야 한다.
//numbers의 접근 제어자인 private을 변경할 수 없다.
//Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
//Lotto의 패키지 변경은 가능하다.

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = orderLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String toStringForDisplay(){
        return numbers.toString();
    }

    private List<Integer> orderLotto(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        // 리스트 정렬
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

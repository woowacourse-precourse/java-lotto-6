package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        //아래를 변경해서 copyOf와 stream의 to List를 사용해서 간단하게 불변으로 만들 수 있지만 함수명이 불변을 설정했다는 것을 알 수 있게 설정
        this.numbers = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.numbersSize(numbers);
        LottoValidator.numbersDuplication(numbers);
    }

    // TODO: 추가 기능 구현

    public void show() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

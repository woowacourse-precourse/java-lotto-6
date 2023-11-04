package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> initialNumbers = new ArrayList<>(numbers);
        //정렬할때 새 객체를 만들어주지 않으면 오류가 발생하는 이유는?
        //입력으로 가져올때 마지막에 toList 메서드를 사용해서 List로 변환후에 가져오게 되는데 이때
        //toList는 불변성으로 바꿔준다.
        Collections.sort(initialNumbers);
        //아래를 변경해서 copyOf와 stream의 to List를 사용해서 간단하게 불변으로 만들 수 있지만 함수명이 불변을 설정했다는 것을 알 수 있게 설정
        this.numbers = Collections.unmodifiableList(new ArrayList<>(initialNumbers));
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.numbersSizeDifferent(numbers);
        LottoValidator.numbersOverValueRange(numbers);
        LottoValidator.numbersDuplicated(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}

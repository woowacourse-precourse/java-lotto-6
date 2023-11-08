package lotto.domain;

import lotto.constant.LottoValue;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final static String OPEN_DELIMITER = "[";
    private final static String CLOSE_DELIMITER = "]";
    private final static String BLANK_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoValue.NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public void printLotto() {
        List<Integer> sortedLottoNumber = sortLottoNumber();

        String lotto = OPEN_DELIMITER;
        lotto += sortedLottoNumber.stream()
                .map(Object::toString)
                .collect(Collectors.joining(BLANK_DELIMITER)) + CLOSE_DELIMITER;

        OutputView.printMessage(lotto);
    }

    private List<Integer> sortLottoNumber() {
        return numbers.stream().sorted().toList();
    }
}

/*
*
- 접근 제어자(private) 변경 불가
- 필드(인스턴스 변수)를 추가 X
- 패키지 변경 가능
* */
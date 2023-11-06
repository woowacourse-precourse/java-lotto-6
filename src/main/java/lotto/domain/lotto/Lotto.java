package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있습니다.");
            }
        }
    }

    /**
     * 로또를 오른 차순으로 정리
     */
    public List<Integer> organizeLotto() {
        List<Integer> organizeLotto = new ArrayList<>(this.numbers);

        Collections.sort(organizeLotto);

        return organizeLotto;
    }

    public StringBuilder giveInformation() {
        int sizeNumbers = numbers.size();
        StringBuilder informationOfNumbers = new StringBuilder();
        int num = 0;
        List<Integer> organizeLotto = organizeLotto();

        informationOfNumbers.append("[");

        for (int i = 0; i < sizeNumbers; i++) {
            num = organizeLotto.get(i);
            informationOfNumbers.append(num);
            if (i != sizeNumbers - 1) {
                informationOfNumbers.append(", ");
            }
        }
        informationOfNumbers.append("]");

        return informationOfNumbers;
    }

    public Integer getNumber(Integer index) {
        return numbers.get(index);
    }
}

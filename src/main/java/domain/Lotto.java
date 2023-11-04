package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(Removeduplication(numbers));
        this.numbers = numbers;
    }

    private List<Integer> Removeduplication(List<Integer> numbers) {
        Set<Integer> lottoSet = new HashSet<>(numbers);
        return new ArrayList<>(lottoSet);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) { // 상수 처리 필요
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 없는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    // 중복 확인 기능
    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }
}

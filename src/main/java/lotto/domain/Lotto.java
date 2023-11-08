package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 로또 번호의 문자열 반환
    public String getLottoString() {
        return numbers.toString();
    }

    // 로또 번호의 리스트 반환
    public List<Integer> getNumbers() {
        return numbers;
    }
}

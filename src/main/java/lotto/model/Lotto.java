package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개만 뽑을 수 있습니다");
        }
    }

    // 숫자가 몇 개 포함되어 있는지 개수 반환
    public int matchCount(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containLottoNumber)
                .count();
    }

    // 입력한 당첨 번호와 랜덤으로 가져온 숫자들 포함 여부
    public boolean containLottoNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력 가능합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> {
            if (Objects.equals(number, numbers.get(numbers.size() - 1))) {
                sb.append(number).append("]");
                return;
            }
            sb.append(number).append(", ");
        });
        return sb.toString();
    }

    public boolean isContain(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        int count = (int) numbers.stream().filter(winningLotto::isContain).count();
        return LottoResult.calculate(count, winningLotto.isContainBonusNumber(numbers));
    }
}

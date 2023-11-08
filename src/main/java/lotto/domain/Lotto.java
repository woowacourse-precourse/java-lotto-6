package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void validateContainsBonusInLotto(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자가 필요합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (isNotRange(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 로또는 1~45 범위의 숫자만 사용할 수 있습니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long lottoSize = numbers.stream()
                .distinct()
                .count();

        if (lottoSize != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복될 수 없습니다.");
        }
    }

    private boolean isNotRange(int number) {
        return !(LottoConstant.LOTTO_MIN_NUMBER <= number
                && number <= LottoConstant.LOTTO_MAX_NUMBER);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

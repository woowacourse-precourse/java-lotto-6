package lotto;

import java.util.List;
import static lotto.LottoProperty.LOTTO_NUMBER_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE.getLottoProperty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자이어야 합니다");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자이어야 합니다");
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}

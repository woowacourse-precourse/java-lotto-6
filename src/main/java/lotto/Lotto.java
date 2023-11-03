package lotto;

import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED;

import java.util.List;
import lotto.utils.LottoUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(LottoUtil::validateLottoNum);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean[] visited = new boolean[46];
        numbers.forEach((num) -> {
            if (visited[num]) {
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATED.getMessage());
            }
            visited[num] = true;
        });
    }
}

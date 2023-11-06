package lotto.model.lotto;

import static lotto.utils.Validator.validateLottoDuplicates;
import static lotto.utils.Validator.validateLottoSize;

import java.util.List;
import lotto.utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers.forEach(Validator::validateLottoRange);
        validateLottoSize(numbers);
        validateLottoDuplicates(numbers);
    }

    public int countMatchNumbers(Winning winning) {
        return (int) numbers.stream().filter(winning.getLotto()::isMatchNumber).count();
    }

    public boolean isMatchNumber(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

package lotto.domain;

import lotto.config.ConstNum;
import lotto.config.LottoErrorMessage;
import lotto.validation.LottoValidator;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatedValidate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != ConstNum.LENGTH.getNum()) {
            OutputView.errorMessage(LottoErrorMessage.INCORRECT_LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplicatedValidate(List<Integer> numbers) {
        LottoValidator.DuplicatedNum(numbers);
    }

    public Boolean hasNumber(Integer num) {
        return numbers.contains(num);
    }

    public String getLotto() {
        return Arrays.toString(numbers.toArray());
    }
}

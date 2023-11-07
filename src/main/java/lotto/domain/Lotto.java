package lotto.domain;

import lotto.UI.OutputHandler;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoEnum;
import lotto.utils.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNull(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateBetweenOneToFortyFive(numbers);
        OutputHandler.addLotto(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.LOTTO_SIZE.getValue())
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER_ERROR.getError());
    }

    private void validateDuplicate(List<Integer> numbers) { // todo: 중복 검사는 꼭 해야함!!
        for (int i = 0; i < numbers.size(); i++) {
            if (Validator.isDuplicate(numbers, numbers.get(i), i))
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getError());
        }
    }

    private void validateBetweenOneToFortyFive(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!Validator.isOneToFortyFive(numbers.get(i)))
                throw new IllegalArgumentException(ErrorMessage.NOT_ONE_TO_FORTYFIVE_ERROR.getError());
        }
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers == null) throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getError());
    }
}

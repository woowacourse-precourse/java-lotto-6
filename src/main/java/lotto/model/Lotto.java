package lotto.model;

import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.LOTTO_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (validateDuplicateValue(numbers)) {
            OutputView.printError(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            OutputView.printError(ErrorMessage.SIZE_IS_NOT_SIX.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.SIZE_IS_NOT_SIX.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compare(List<Integer> _winning) {
        List<Integer> _same = getNumbers().stream().filter(
                _number -> {
                    return _winning.contains(_number);
                }).toList();
        return _same.size();
    }

    public static boolean validateDuplicateValue(List<Integer> _lotto) {
        _lotto = _lotto.stream().distinct().collect(Collectors.toList());
        if (_lotto.size() != LOTTO_SIZE.getNumber()) {
            return true;
        }
        return false;
    }
}

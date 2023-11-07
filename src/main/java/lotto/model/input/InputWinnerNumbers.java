package lotto.model.input;

import static lotto.util.constants.Numbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.util.constants.Numbers.MINIMUM_LOTTO_NUMBER;
import static lotto.util.exception.ErrorMessage.INVALID_LOTTO_NUMBER;
import static lotto.util.exception.ErrorMessage.NOT_INTEGER;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.util.exception.LottoException;
import lotto.util.input.InputList;

public class InputWinnerNumbers extends InputList<Integer> {
    InputWinnerNumbers(String input) {
        super(input);
    }

    public static InputWinnerNumbers getInstance(String input) {
        return new InputWinnerNumbers(input);
    }

    @Override
    public Lotto sendInputData() {
        return new Lotto(list);
    }

    @Override
    public void validate() {
        if (notLottoNumbers()) {
            throw LottoException.of(INVALID_LOTTO_NUMBER);
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

    protected List<Integer> convertElements(List<String> input) {
        return input.stream()
                .map(this::checkNumber)
                .collect(Collectors.toList());
    }

    private Integer checkNumber(String element) {
        Integer number;
        try {
            number = Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw LottoException.of(NOT_INTEGER);
        }
        return number;
    }

    private boolean notLottoNumbers() {
        for (Integer number : list) {
            if (number < MINIMUM_LOTTO_NUMBER.getNumber() || number > MAXIMUM_LOTTO_NUMBER.getNumber()) {
                return true;
            }
        }
        return false;
    }
}

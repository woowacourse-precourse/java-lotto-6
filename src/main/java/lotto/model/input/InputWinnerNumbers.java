package lotto.model.input;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.util.input.InputList;

public class InputWinnerNumbers extends InputList<Integer> {
    InputWinnerNumbers(String input) {
        super(input);
    }

    public static InputWinnerNumbers getInstance(String input) {
        return new InputWinnerNumbers(input);
    }

    public void validate() {
        if (notLottoNumbers()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Lotto sendInputData() {
        return new Lotto(list);
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
            throw new IllegalArgumentException();
        }
        return number;
    }

    private boolean notLottoNumbers() {
        for (Integer number:list) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }
}

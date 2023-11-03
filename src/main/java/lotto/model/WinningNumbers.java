package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validation;
import lotto.view.InputView;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers() {
        this.numbers = new ArrayList<>();
    }

    public Lotto getLotto(String input) {
        Validation.validateComma(input);
        for (String token : input.split(",")) {
            int oneNum = validate(token, numbers);
            numbers.add(oneNum);
        }
        return new Lotto(numbers);
    }

    public int validate(String input, List<Integer> winningNum) {
        int oneNum = Validation.validateInteger(input);
        Validation.validateNumberRange(oneNum);
        return oneNum;
    }

    public void clearList() {
        numbers.clear();
    }

    public Lotto getValidWinningNum(InputView inputView) {
        Lotto result;
        while (true) {
            try {
                result = getLotto(inputView.inputWinnerNumbers());
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                clearList();
            }
        }
        return result;
    }
}
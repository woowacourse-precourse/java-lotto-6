package lotto.model;

import java.util.Arrays;
import java.util.List;

import static lotto.model.validator.InputValidator.numberMustBe1To45;

public class WinningNumber {
    Lotto answer;
    public WinningNumber(String winningNumber) {
        List<Integer> lotto
                = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList();
        numberMustBe1To45(lotto);
        answer = new Lotto(lotto);
    }

    @Override
    public boolean equals(Object expectedNumbers){
        return answer.equals(expectedNumbers);
    }
}

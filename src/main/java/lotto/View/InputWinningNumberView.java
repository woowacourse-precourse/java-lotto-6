package lotto.View;

import lotto.Util.Rule;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputWinningNumberView extends InputView{

    public List<Integer> getValue() {
        System.out.println(Rule.INPUTWINNINGNUM_MESSAGE);
        String result = inputValue();
        System.out.println();
        validate(result);
        return Stream.of(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(String inputValue) {
        validateInput(inputValue);
    }

    private void validateInput(String inputValue) {
        if(!Rule.WINNUNG_PATTERN.matcher(inputValue).matches())
            throw new IllegalArgumentException(Rule.NOTNUMBER_PATTERN);
    }
}

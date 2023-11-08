package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.validator.Validate;
import lotto.view.ErrorMessage;

public class InputNumber {

    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    public List<Integer> InputLottos() {
        String userInput = Console.readLine();
        System.out.println();
        validate(userInput);
        return Stream.of(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(String inputValue) {
        validateInput(inputValue);
    }

    private void validateInput(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getMessage());
        }
    }

    public int InputBonus() {
        String BonusNumber = Console.readLine();
        return Integer.parseInt(BonusNumber);
    }
}

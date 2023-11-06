package lotto.validate;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumberValidation implements LottoValidation {
    @Override
    public boolean validate(final String userInput) {
        List<String> numbers = Arrays.stream(userInput.split(",")).distinct().toList();
        if (numbers.size() != 6) return false;
        for (String number : numbers) {
            if (!Pattern.matches("^(?:[1-9]|[1-3][0-9]|4[0-5])$", number)) return false;
        }
        return true;
    }
}

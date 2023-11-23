package lotto.dto;

import java.util.List;
import lotto.utils.Delimiter;

public class LottosDto {

    private final List<String> numbers;
    private final String joinedNumbers;

    public LottosDto(final List<String> numbers) {
        this.numbers = numbers;
        this.joinedNumbers = Delimiter.joinWithComma(numbers);
    }

    @Override
    public String toString() {
        return Delimiter.FormatWithTarget(this.joinedNumbers);
    }
}

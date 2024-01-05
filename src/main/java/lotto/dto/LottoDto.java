package lotto.dto;

import java.util.List;

public class LottoDto {

    private static final String LOTTO_PRINT_FORMAT = "[%s]";
    private static final String DELIMITER_COMMA = ", ";

    private final List<String> numbers;
    private final String joinedNumbers;

    public LottoDto(List<String> numbers) {
        this.numbers = numbers;
        this.joinedNumbers =  String.join(DELIMITER_COMMA, this.numbers);
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public String toString() {
        return String.format(LOTTO_PRINT_FORMAT, joinedNumbers);
    }
}

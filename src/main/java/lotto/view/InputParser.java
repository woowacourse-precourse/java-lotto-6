package lotto.view;

import static lotto.exception.ExceptionMessage.INVALID_LOTTO_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoGameException;

public class InputParser {

    public static final String SPLIT_DELIMITER = ",";

    public List<Integer> parseLottoNumbers(String numbers) {
        List<Integer> parsedNumbers;
        try {
            parsedNumbers = Arrays.stream(numbers.split(SPLIT_DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new LottoGameException(String.format(INVALID_LOTTO_INPUT.getMessage(), numbers));
        }
        return parsedNumbers;
    }
}

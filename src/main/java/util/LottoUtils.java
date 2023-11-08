package util;

import consts.LottoConsts;
import exception.WrongLottoSizeException;
import exception.WrongRangeLottoNumberException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtils {
    public static List<Integer> lottoNumbersParser(String inputLottoNumbers) {
        List<Integer> numbers = Stream.of(inputLottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validate(numbers);

        return numbers;
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConsts.LOTTO_SIZE) {
            throw new WrongLottoSizeException();
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !(LottoConsts.MIN_RANGE <= number && number <= LottoConsts.MAX_RANGE))) {
            throw new WrongRangeLottoNumberException();
        }

    }
}
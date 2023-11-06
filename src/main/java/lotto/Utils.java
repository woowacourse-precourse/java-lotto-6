package lotto;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ExceptionMessage.NOT_NUMBER;

public class Utils {

    public static int convertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.get());
        }
    }

    public static List<Integer> convertStringArrayToIntegerList(String[] inputs){
        return Arrays.stream(inputs)
                .map(Utils::convertStringToInt)
                .toList();
    }

    public static List<LottoNumber> convertIntegerListToLottoNumberList(List<Integer> inputs){
        return inputs.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }
}

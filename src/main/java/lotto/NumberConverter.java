package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class NumberConverter {

    public static LottoNumber convertNumberToLottoNumber(int number) {
        return new LottoNumber(number);
    }

    public static List<LottoNumber> convertNumberToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

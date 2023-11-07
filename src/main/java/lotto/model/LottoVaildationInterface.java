package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface LottoVaildationInterface {
    void lottoLengthError(List<Integer> numbers);

    void lottoDuplictionError(List<Integer> numbers);

    void lottoNumberError(List<Integer> numbers);

    static void lottoValidation(LottoVaildationInterface instance
            ,List<Integer> numbers) throws IllegalArgumentException {
        instance.lottoDuplictionError(numbers);
        instance.lottoNumberError(numbers);
        instance.lottoLengthError(numbers);
    }
}

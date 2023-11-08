package lotto.model;

import java.util.List;

public interface ILottoVaildation {
    void lottoLengthError(List<Integer> numbers);

    void lottoDuplictionError(List<Integer> numbers);

    void lottoNumberError(List<Integer> numbers);

    static void lottoValidation(ILottoVaildation instance
            ,List<Integer> numbers) throws IllegalArgumentException {
        instance.lottoDuplictionError(numbers);
        instance.lottoNumberError(numbers);
        instance.lottoLengthError(numbers);
    }

}

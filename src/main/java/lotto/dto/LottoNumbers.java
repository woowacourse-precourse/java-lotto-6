package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    private LottoNumbers(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(final Lotto lotto) {
        List<LottoNumber> numbers = lotto.getLottoNumbers();
        List<Integer> lottoNumbers = numbers.stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .toList();
        return new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
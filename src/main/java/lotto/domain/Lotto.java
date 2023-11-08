package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final String OUT_OF_LOTTO_NUMBERS_SIZE = "[ERROR] 로또 번호는 6개입니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 입력 값은 중복을 허용하지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        validateUniqueElements(lottoNumbers);
        validateLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLength(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBERS_SIZE);
        }
    }

    private void validateUniqueElements(List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}

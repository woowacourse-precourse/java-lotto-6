package lotto;

import java.util.HashSet;
import java.util.Set;

public record Lotto(Set<LottoNumber> lottoNumbers) {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public Lotto {
        validateLottoSize(lottoNumbers);
    }

    public static Lotto issueLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            LottoNumber randomLottoNumber = LottoNumber.createRandomLottoNumber();
            lottoNumbers.add(randomLottoNumber);
        }
        return new Lotto(lottoNumbers);
    }

    private void validateLottoSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}

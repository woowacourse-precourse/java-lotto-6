package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto issueAutoPickNumbersLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            LottoNumber randomLottoNumber = LottoNumber.createRandomLottoNumber();
            lottoNumbers.add(randomLottoNumber);
        }
        return new Lotto(lottoNumbers);
    }

    public static Lotto issueChooseNumbersLotto(List<Integer> userChoosedNumbers) {
        Set<LottoNumber> lottoNumbers = userChoosedNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Set.copyOf(lottoNumbers);
    }

    private void validateLottoSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}

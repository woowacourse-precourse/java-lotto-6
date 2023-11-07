package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record Lotto(Set<LottoNumber> lottoNumbers) {

    private static final int LOTTO_NUMBERS_SIZE = 6;


    public Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
    }

    public static Lotto issueAutoPickNumbersLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            LottoNumber randomLottoNumber = LottoNumber.createRandomLottoNumber();
            lottoNumbers.add(randomLottoNumber);
        }
        return new Lotto(lottoNumbers);
    }

    public static Lotto issueChooseNumbersLotto(List<Integer> userChooseNumbers) {
        Set<LottoNumber> lottoNumbers = userChooseNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    private void validateLottoSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}

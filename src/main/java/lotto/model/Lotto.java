package lotto.model;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "로또 숫자는 %d개 여야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto issueAutoPickNumbersLotto() {
        List<LottoNumber> randomLottoNumbers = LottoNumber.createRandomLottoNumbers(
            LOTTO_NUMBERS_SIZE);
        return new Lotto(randomLottoNumbers);
    }

    public static Lotto issueChooseNumbersLotto(List<Integer> userChoosedNumbers) {
        List<LottoNumber> lottoNumbers = userChoosedNumbers.stream()
            .map(LottoNumber::new)
            .distinct()
            .toList();

        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(LOTTO_NUMBERS_SIZE));
        }
    }
}

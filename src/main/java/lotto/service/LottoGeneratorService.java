package lotto.service;

import static lotto.domain.LottoRule.LOTTO_LENGTH;
import static lotto.domain.LottoRule.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoRule.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoGeneratorService {
    public Lotto generateLotto() {
        List<Integer> numbers = generateUniqueNumbers();
        List<LottoNumber> lottoNumbers = mapToLottoNumbers(numbers);
        return createLotto(lottoNumbers);
    }

    private Lotto createLotto(List<LottoNumber> lottoNumbers) {
        return Lotto.from(lottoNumbers);
    }

    private List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    private List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(),
                LOTTO_LENGTH.getValue());
    }
}

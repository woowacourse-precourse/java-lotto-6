package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_TICKET_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateLottoDuplication(lottoNumbers);
        validateWinningNumbersRange(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int countMatchingNumbers(Lotto winningNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningNumbers.lottoNumbers::contains)
                .count();
    }

    public boolean matchBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public LottoResult match(Lotto winningNumbers,
                             int bonusNumber) {
        return LottoResult.findResult(countMatchingNumbers(winningNumbers), matchBonusNumber(bonusNumber));
    }

    private void validateWinningNumbersRange(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(this::validateWinningNumberRange);
    }

    private void validateWinningNumberRange(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    private void validateLottoDuplication(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream().distinct().count();

        if (count != lottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다.");
        }
    }
}

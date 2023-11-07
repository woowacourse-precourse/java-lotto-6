package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) {
        this.validateIsEmpty(lottoNumbers);
        this.validateSize(lottoNumbers);
        this.validateIsDuplicate(lottoNumbers);
    }

    private void validateIsEmpty(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("비어있을 수 없음.");
        }
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6개 여야 함.");
        }
    }

    private void validateIsDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> duplicateCheck = new HashSet<>();
        lottoNumbers.forEach(number -> {
            if (!duplicateCheck.add(number)) {
                throw new IllegalArgumentException("당첨번호는 중복될 수 없음.");
            }
        });
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getHitCount(List<Integer> numbers) {
        return (int) this.lottoNumbers.stream()
                .filter(number -> number.isHit(numbers))
                .count();
    }
}

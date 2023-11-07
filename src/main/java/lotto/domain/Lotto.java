package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        validateDuplicated(lottoNumbers);
        validateOutOfRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void validateDuplicated(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateOutOfRange(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber < 1 || lottoNumber > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
        }
    }
    
    public int match(List<Integer> lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public final int match(WinningLotto winningNumber) {
        return winningNumber.match(this.lottoNumbers);
    }

    public final boolean hasBonusNumber(WinningLotto winningNumber) {
        return winningNumber.containBonusNumber(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}

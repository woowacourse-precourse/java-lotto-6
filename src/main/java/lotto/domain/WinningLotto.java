package lotto.domain;

import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private static final int MINIMUM_WINNING_COUNT = 3;
    private static final int ZERO_COUNT = 0;
    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 45;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_RANGE || bonusNumber > MAXIMUM_RANGE) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1부터 45까지 존재합니다.");
        }
    }

    private void validateBonusNumberDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[Error] 로또 번호에 보너스 번호와 중복된 번호가 존재합니다.");
        }
    }

    public int lottoNumbersMatch(Lotto lottoNumbers) {
        int matchCount = winningNumbers.getNumbers().stream()
                .filter(it -> lottoNumbers.getNumbers().contains(it))
                .collect(Collectors.toList()).size();
        if (matchCount < MINIMUM_WINNING_COUNT) {
            return ZERO_COUNT;
        }
        return matchCount;
    }

    public boolean lottoBonusNumberMatch(Lotto lottoNumbers) {
        return lottoNumbers.getNumbers().contains(bonusNumber);
    }
}

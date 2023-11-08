package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String NOT_CORRECT_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.";
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.lotto = new Lotto(lotto);
        validate(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validate(lotto.getLottoNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(NOT_CORRECT_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public Rank match(Lotto lotto) {
        int matchCount = (int) lotto.getLottoNumbers().stream()
            .filter(number -> this.lotto.getLottoNumbers().contains(number))
            .count();
        boolean matchBonus = lotto.getLottoNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
    }
}

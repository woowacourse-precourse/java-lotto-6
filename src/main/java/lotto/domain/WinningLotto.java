package lotto.domain;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String ERROR_MESSAGE_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_BONUS_NUMBER_DUPLICATION = "[ERROR] 보너스 번호는 로또번호와 중복이 없어야 합니다.";


    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_RANGE);
        }
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_DUPLICATION);

        }
    }

    public Rank match(Lotto userLotto) {
        int matchNumberCnt = this.lotto.getMatchNumberCnt(userLotto);
        return Rank.findRank(matchNumberCnt, userLotto.hasNumber(this.bonusNumber));
    }

}

package domain;

import config.ErrorMessage;

public class WinningLotto { // 싱글톤 패턴으로 관리

    private static final int FIVE_CORRECT = 5;
    private static final int BONUS_COUNT = 2;
    private static WinningLotto defaultWinningLotto;
    private Lotto numbers;
    private Integer bonusNumber;

    private WinningLotto() {
    }

    public static WinningLotto getInstance() {
        if(defaultWinningLotto == null) {
            defaultWinningLotto = new WinningLotto();
        }
        return defaultWinningLotto;
    }

    public void setNumbers(Lotto lotto) {
        numbers = lotto;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if(numbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS.getMessage());
        }
    }

    public int countWinNumber(Lotto lotto) {
        int count = this.numbers.compareLotto(lotto);
        if(count == FIVE_CORRECT && lotto.containsNumber(bonusNumber)) {
            count += BONUS_COUNT;
        }
        return count;
    }

}

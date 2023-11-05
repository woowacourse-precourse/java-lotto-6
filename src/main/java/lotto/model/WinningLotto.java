package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
//        validateBonusNumberRange(bonusNumber);
//        validateBonusNumberRange(bonusNumber);
//        validateBonusNumberUnique(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

//    private void validateBonusNumberRange(int bonusNumber) {
//        if (!isValidRange(bonusNumber)) {
//            throw new IllegalArgumentException("보너스 번호는 1~45 사이만 입력 가능합니다.");
//        }
//    }
//
//    private void validateBonusNumberUnique(int bonusNumber) {
//        if (winningLotto.contains(bonusNumber)) {
//            throw new IllegalArgumentException("당첨 번호화 중복된 번호는 입력할 수 없습니다.");
//        }
//    }
//
//    private boolean isValidRange(int number) {
//        return MIN_RANGE <= number && number <= MAX_RANGE;
//    }
}
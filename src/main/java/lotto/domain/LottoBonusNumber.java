package lotto.domain;

import lotto.constant.LottoConstant;

public class LottoBonusNumber {

    private int bonusNumber;

    public LottoBonusNumber(LottoWinningNumber lottoWinningNumber, int bonusNumber) {
        validateDuplicate(lottoWinningNumber, bonusNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoWinningNumber lottoWinningNumber, int bonusNumber) {
        if (lottoWinningNumber.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 존재하는 번호로 보너스 번호를 입력할 수 없습니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_START_NUMBER ||
                bonusNumber > LottoConstant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(
                    "보너스 번호는 " + LottoConstant.LOTTO_START_NUMBER + " 이상, "
                            + LottoConstant.LOTTO_END_NUMBER + " 이하여야 합니다.");
        }
    }

    public boolean matches(int bonusNumber) {
        return this.bonusNumber == bonusNumber;
    }

}

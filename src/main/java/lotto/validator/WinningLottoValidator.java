package lotto.validator;

import java.util.List;

/**
 * 당첨 로또를 검증하는 클래스
 */
public class WinningLottoValidator {

    private WinningNumsValidator winningNumsValidator;

    private BonusNumValidator bonusNumValidator;

    public WinningLottoValidator(WinningNumsValidator winningNumsValidator, BonusNumValidator bonusNumValidator) {
        this.winningNumsValidator = winningNumsValidator;
        this.bonusNumValidator = bonusNumValidator;
    }

    public boolean isUniqueBonusNum(List<Integer> winningNums, Integer bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 보너스 번호 입력값");
        }
        return true;
    }

    public boolean isValidWinningNums(String winningNums) {
        return winningNumsValidator.isValid(winningNums);
    }

    public boolean isValidBonusNum(String bonusNum) {
        return bonusNumValidator.isValid(bonusNum);
    }

}

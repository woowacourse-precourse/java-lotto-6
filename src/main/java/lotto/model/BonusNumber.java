package lotto.model;

import lotto.constant.LottoConstant;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumInput) {
        validateBonusNumber(bonusNumInput);
        this.bonusNumber = Integer.parseInt(bonusNumInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(String bonusNumInput) {
        validateIsNumber(bonusNumInput);
        validateBonusIsPositive(bonusNumInput);
        validateBonusRange(bonusNumInput);
    }

    private void validateIsNumber(String bonusNumInput) {
        try {
            Integer.parseInt(bonusNumInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호에 숫자 외의 문자와 공백은 포함될 수 없습니다. 1부터 45까지의 숫자를 입력해주세요.");
        }
    }

    private void validateBonusIsPositive(String bonusNumInput) {
        int num = Integer.parseInt(bonusNumInput);
        if (num <= 0) {
            throw new IllegalArgumentException("보너스 번호는 음수일 수 없습니다. 1부터 45까지의 숫자를 입력해주세요.");
        }
    }

    private void validateBonusRange(String bonusNumInput) {
        int number = Integer.parseInt(bonusNumInput);
        if (number < LottoConstant.MIN_NUMBER || number > LottoConstant.MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 " + LottoConstant.MIN_NUMBER + "부터 "
                    + LottoConstant.MAX_NUMBER + "까지의 숫자만 가능합니다.");
        }
    }
}

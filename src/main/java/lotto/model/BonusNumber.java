package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(String bonusNumberStr) {
        validateEmpty(bonusNumberStr);
        int bonusNumber = validateNotNumber(bonusNumberStr);
        validateInvalidLottoNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateNull(String bonusNumberStr) {
        if (bonusNumberStr == null) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null입니다.");
        }
    }

    private void validateEmpty(String bonusNumberStr) {
        if (bonusNumberStr.isEmpty() || bonusNumberStr.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }
    }

    private int validateNotNumber(String bonusNumberStr) {
        try {
            return Integer.parseInt(bonusNumberStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateInvalidLottoNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 수여야 합니다.");
        }
    }
}

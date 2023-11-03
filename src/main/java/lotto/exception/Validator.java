package lotto.exception;



public final class Validator {
    public static void validatePurChaseAmount(String amount) {
        if(!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
        int amountInteger = Integer.parseInt(amount);
        if(amountInteger % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액을 다시 입력해주세요");
        }
    }

    public static void validateWinningNumber(String winningNum) {
    }

    public static void validateBonusNumber(String bonusNumber) {
    }
}

package lotto.domain;

public class BonusNumber {
    private static Integer bonusNumber;

    public void setBonusNumber(String number) {
        validate(number);
        bonusNumber = Integer.parseInt(number);
    }

    private static void validate(String number) {
        validateIsNumber(number);
        validateIsNumberInRange(number);
        validateIsUniqueNumber(number);
    }

    private static void validateIsNumber(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateIsNumberInRange(String number) {
        boolean IsNumberInRange = (Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45);
        if(!IsNumberInRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateIsUniqueNumber(String number) {
        WinningNumber winningNumber = new WinningNumber();
        boolean isUnique = winningNumber.getWinningNumber().contains(number);
        if(!isUnique) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}

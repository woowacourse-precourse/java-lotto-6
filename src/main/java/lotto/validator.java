package lotto;

public class validator {
    public static boolean validatePurchaseAmount(int money) {
        return money % 1000 == 0;
    }

    public static boolean validateWinningNumber(String winningNumberString) {
        String regex = "^\\d+(,\\d+)*$";
        return winningNumberString.matches(regex);
    }

    public static boolean validateBonusNumber(String bonusNumberString) {
        String regex = "^\\d+$";
        return bonusNumberString.matches(regex);
    }
}

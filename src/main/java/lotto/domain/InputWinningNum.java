package lotto.domain;

public class InputWinningNum {

    public static void inputWinningNumNotInt(String winningNum) {
        try {
            Integer.parseInt(winningNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void inputBonusNumNotInt(String bonusNum) {
        try {
            Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void inputBonusNumNotRange(int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException();
        }
    }
}

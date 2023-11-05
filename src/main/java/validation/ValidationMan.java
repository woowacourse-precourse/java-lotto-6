package validation;

import lotto.Lotto;

public class ValidationMan {

    private final static int STANDARD_MONEY = 1000;

    public boolean validateMoney(String money) {
        if (!money.matches("\\d+")) {
            return false;
        }
        if (Integer.parseInt(money) % STANDARD_MONEY != 0) {
            return false;
        }
        return true;
    }

    public boolean validateNumbers(String[] userNumbers) {
        try {
            Integer[] forException = new Integer[userNumbers.length];
            for (int i = 0; i < userNumbers.length; i++) {
                forException[i] = Integer.parseInt(userNumbers[i]);
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean valudateBonusNumber(Lotto userLotto, String userBonusNumber) {
        if (!userBonusNumber.matches("\\d+")) {
            return false;
        }
        if (userLotto.getNumbers().contains(Integer.parseInt(userBonusNumber))) {
            return false;
        }
        return true;
    }

}

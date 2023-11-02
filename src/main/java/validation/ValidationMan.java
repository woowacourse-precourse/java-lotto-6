package validation;

public class ValidationMan {

    private final static int STANDARD_MONEY = 1000;

    public boolean validateMoney(String money) {
        if (!(money.matches("\\d+"))) {
            return false;
            if (Integer.parseInt(money) % STANDARD_MONEY != 0) {
                return false;
            }
        }
        return true;
    }
}

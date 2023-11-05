package lotto;

public class Validate {

    public void IsThousands(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void IsInteger(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

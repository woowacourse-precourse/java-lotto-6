package lotto.model;

public class BonusNumber {

    private int number;

    public BonusNumber(String number) {
        this.number = parstInt(number);
    }

    public int getNumber() {
        return number;
    }

    public int parstInt(String num) {
        return Integer.parseInt(num);

    }
}

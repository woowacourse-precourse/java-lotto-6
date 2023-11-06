package Except;

import Input.Input;
import Message.Message;

import java.util.List;

public class Except {
    private static Message numberIncorrect = Message.numberIncorrectFormat;
    private static Message outOfRange = Message.moneyOutOfRange;
    private static Message invalidFormat = Message.moneyInvalidFormat;
    private static final String INTEGER_REGEX = "^-?\\d+$";

    public int outOfRangeMoney(String money) {
        int result = outOfRange.getCode();
        Input input = new Input();
        try {
            if (!money.matches(INTEGER_REGEX)) {
                throw new IllegalArgumentException();
            }
            result = Integer.parseInt(money);
            result = incorrectFormatMoney(result);
        } catch (IllegalArgumentException iae) {
            System.out.println(outOfRange.getMessage());
        }
        return result;
    }

    public int incorrectFormatMoney(int money) {
        int result = invalidFormat.getCode();
        try {
            if (money < 0 || money % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            result = money;
        } catch (IllegalArgumentException iae) {
            System.out.println(invalidFormat.getMessage());
        }
        return result;
    }

    public String numberLengthCheck(String number) {
        String result = number;
        try {
            result = result.replaceAll("\\s", "");
            if (result.length() != number.length()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            result = "";
            System.out.println(numberIncorrect.getMessage());
        }
        return result;
    }
}

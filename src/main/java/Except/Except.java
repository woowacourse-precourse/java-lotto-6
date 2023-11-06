package Except;

import Input.Input;
import Message.Message;

import java.util.ArrayList;
import java.util.List;

public class Except {
    private static Message numberIncorrectFormat = Message.numberIncorrectFormat;
    private static Message numberOutOfRange = Message.numberOutOfRange;
    private static Message numberIncorrect = Message.numberIncorrect;
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
            System.out.println(numberIncorrectFormat.getMessage());
        }
        return result;
    }

    public int numberCheckNumber(String number) {
        int result = numberIncorrect.getCode();
        try {
            if (!number.matches(INTEGER_REGEX)) {
                throw new IllegalArgumentException();
            }
            result = Integer.parseInt(number);
        } catch (IllegalArgumentException iae) {
            System.out.println(numberIncorrect.getMessage());
        }
        return result;
    }

    public int numberRangeNumber(int number) {
        int result = numberOutOfRange.getCode();
        try {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
            result = number;
        } catch (IllegalArgumentException iae) {
            System.out.println(numberOutOfRange.getMessage());
        }
        return result;
    }

    public List<Integer> numberAllCheckNumber(String number) {
        String[] check_number = number.split(",");
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < check_number.length; i++) {
            int checking = numberCheckNumber(check_number[i]);
            checking = numberRangeNumber(checking);
            if (checking < 0) {
                break;
            }
        }
        return result;
    }
    public List<Integer> numberCheckAll(String number){
        List<Integer> result = new ArrayList<>();
        String length_check = numberLengthCheck(number);

    }
}

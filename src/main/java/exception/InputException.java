package exception;

import java.util.regex.Pattern;

public class InputException {

    private static final Pattern regex = Pattern.compile("[0-9]+");

    private InputException(){
    }

    public static int validateInteger(String pay) {
        if(regex.matcher(pay).matches()) {
            return Integer.parseInt(pay);
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }

    public static int validatePayUnit(int pay) {
        if(pay > 0 && pay % 1000 == 0) {
            return pay;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 가능합니다.");
    }

    public static int validateRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 가능한 숫자범위는 1-45 입니다.");
        }
        return number;
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

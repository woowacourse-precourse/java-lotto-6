package lotto;

public class InputValidator {

    public static Boolean validateType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if('0' > inputValue.charAt(i) || inputValue.charAt(i) > '9') {
                System.out.println("[ERROR] 구입금액은 숫자!\n");
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static Boolean validateUnit(String inputValue) {
        if (Integer.parseInt(inputValue) % 1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위!\n");
            throw new IllegalArgumentException();
        }
        return true;
    }
}

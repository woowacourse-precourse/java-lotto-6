package lotto;

public class Exception {
    public static void NotNumberException(String inputData) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.\n");
        }
    }
}

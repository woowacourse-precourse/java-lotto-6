package lotto.utils;

public class Parser {

    public static int parseStringToInt(String stringValue) {
        try {
            int intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수값을 입력해 주세요.");
        }
    }

}

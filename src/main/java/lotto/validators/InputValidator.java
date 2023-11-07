package lotto.validators;

import java.util.Arrays;
import java.util.HashSet;

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

    public static void validateLength(String[] inputValues) {
        if(inputValues.length != 6) {
            System.out.println("[ERROR] 당첨 번호는 총 6개!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateType(String[] inputValues) {
        for (int i = 0; i < inputValues.length; i++) {
            if (!isNumeric(inputValues[i].charAt(0))) {
                System.out.println("[ERROR] 당첨 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isNumeric(char c) {
        if (!Character.isDigit(c)) {
            return false;
        }
        return true;
    }

    public static void validateRange(String[] inputValues) {
        for (int i = 0; i < inputValues.length; i++) {
            if (Integer.parseInt(inputValues[i]) < 0 || 45 < Integer.parseInt(inputValues[i])) { // 범위
                System.out.println("[ERROR] 당첨 번호는 1이상 45이하!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicate(String[] inputValues) {
        HashSet<String> set = new HashSet<>(Arrays.stream(inputValues).toList());
        if (set.size() < 6) { // 중복
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없음!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!isNumeric(inputValue.charAt(i))) {
                System.out.println("[ERROR] 보너스 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumRange(String inputValue) {
        if(1 >Integer.parseInt(inputValue) || 45 < Integer.parseInt(inputValue)) {
            System.out.println("[ERROR] 보너스 번호는 1이상 45이하!");
            throw new IllegalArgumentException();
        }
    }
}

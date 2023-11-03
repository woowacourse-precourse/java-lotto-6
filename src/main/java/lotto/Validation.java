package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    /**
     * 보너스 번호가 올바른지 확인하는 함수
     *
     * @param input : 보너스 번호
     * @param lotto : 당첨 번호
     */
    public static void bonusNumber(String input, Lotto lotto) {
        isNumeric(input); // 숫자 검사
        isValidLength(input, Config.NUMBER_LENGTH); // 번호 개수 검사
        int bonusNumber = Integer.parseInt(input);
        isInRange(bonusNumber); // 번호 검사
        if (lotto.contains(bonusNumber)) { // 중복 검사
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    /**
     * 올바른 로또 번호인지 검사하는 함수
     *
     * @param input : 검사할 로또 번호 문자열
     */
    public static void winningNumber(String input) {
        isNumeric(input); // 숫자 검사
        isValidLength(input, Config.LOTTO_LENGTH); // 번호 개수 검사
        for (String string : input.split(",")) {
            int number = Integer.parseInt(string);
            isInRange(number); // 번호 검사
        }
        isDuplicate(input); // 중복 검사
    }

    /**
     * 숫자가 중복되는지 검사하는 함수
     *
     * @param input : 숫자로 이루어진 문자열
     */
    public static void isDuplicate(String input) {
        List<Integer> checker = new ArrayList<>();
        for (String string : input.split(",")) {
            int number = Integer.parseInt(string);
            if (checker.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 번호는 중복될 수 없습니다.");
            }
            checker.add(number);
        }
    }

    /**
     * 문자열이 올바른 숫자인지 검사하는 함수
     *
     * @param input : 올바른 단위의 숫자인지 검사할 문자열
     */
    public static void price(String input) {
        isNumeric(input); // 숫자 검사
        isValidLength(input, Config.NUMBER_LENGTH);
        isValidUnit(Integer.parseInt(input)); // 단위 검사
    }

    /**
     * 문자열의 숫자가 원하는 개수만큼 있는지 검사하는 함수
     *
     * @param input : 검사할 로또 문자열
     */
    public static void isValidLength(String input, int length) {
        String[] split = input.split(",", -1);
        if (split.length != length) {
            throw new IllegalArgumentException("[ERROR] " + length + " 개의 번호를 입력해주세요.");
        }
    }

    /**
     * 숫자가 유효 범위 내에 속하는지 검사한다.
     *
     * @param number : 범위를 검사할 숫자
     */
    public static void isInRange(int number) {
        int min = Config.MIN;
        int max = Config.MAX;
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR] " + min + " ~ " + max + " 범위의 숫자만 가능합니다.");
        }
    }

    /**
     * 문자열이 숫자인지 검사하는 함수 ","로 분리하여 검사한다.
     *
     * @param string : 숫자인지 검사할 문자열
     */
    public static void isNumeric(String string) {
        try {
            for (String split : string.split(",", -1)) {
                Integer.parseInt(split);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 숫자의 단위가 올바른지 검사하는 함수
     *
     * @param number : 검사할 숫자
     */
    public static void isValidUnit(int number) {
        int unit = Config.UNIT;
        if (number == 0 || number % unit != 0) {
            throw new IllegalArgumentException("[ERROR] " + unit + "단위로 입력해야 합니다.");
        }
    }
}
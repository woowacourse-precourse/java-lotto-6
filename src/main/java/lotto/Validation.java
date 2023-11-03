package lotto;

public class Validation {

    /**
     * 올바른 로또 번호인지 검사하는 함수
     *
     * @param input : 검사할 로또 번호 문자열
     */
    public static void winningNumber(String input) {
        isNumeric(input); // 숫자 검사
        lottoNumber(input); // 번호 개수 검사
        for (String string : input.split(",")) {
            int number = Integer.parseInt(string);
            Validation.isInRange(number); // 번호 검사
        }
    }

    /**
     * 문자열의 숫자가 로또의 개수만큼 있는지 검사하는 함수
     *
     * @param input : 검사할 로또 문자열
     */
    public static void lottoNumber(String input) {
        String[] split = input.split(",", -1);
        int lottoLength = Config.LOTTO_LENGTH;
        if (split.length != lottoLength) {
            throw new IllegalArgumentException("[ERROR]: " + lottoLength + " 개의 번호를 입력해주세요.");
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
            throw new IllegalArgumentException("[ERROR]: " + min + " ~ " + max + " 범위의 숫자만 가능합니다.");
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
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 문자열이 올바른 숫자인지 검사하는 함수
     *
     * @param input : 올바른 단위의 숫자인지 검사할 문자열
     */
    public static void price(String input) {
        isNumeric(input); // 숫자 검사
        isValidUnit(Integer.parseInt(input)); // 단위 검사
    }

    /**
     * 숫자의 단위가 올바른지 검사하는 함수
     *
     * @param number : 검사할 숫자
     */
    public static void isValidUnit(int number) {
        int unit = Config.UNIT;
        if (number == 0 || number % unit != 0) {
            throw new IllegalArgumentException("[ERROR]: " + unit + "단위로 입력해야 합니다.");
        }
    }
}
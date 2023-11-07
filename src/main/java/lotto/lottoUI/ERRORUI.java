package lotto.lottoUI;

public class ERRORUI {
    public static void NumberFormatException() {
        System.out.println("[ERROR] 숫자를 입력하세요.");
    }

    public static String InputDecimalPointNumberError() {
        return "[ERROR] 정수를 입력하세요.";
    }

    public static String InputNegativeError() {
        return "[ERROR] 양의 정수를 입력하세요.";
    }

    public static String MultipleOfThousandError() {
        return "[ERROR] 입력한 금액은 1000으로 나누어 떨어져야 합니다.";
    }

    public static String InputSixNumberError() {
        return "[ERROR] 6개의 숫자를 입력하세요.";
    }

    public static String CategoryOfValueError() {
        return "[ERROR] 1부터 45 사이의 숫자를 입력하세요.";
    }

    public static String SameNumberExistError() {
        return "[ERROR] 중복된 숫자를 제외하고 입력해주세요.";
    }
}

package lotto.views;

public class Exceptions {
    public Exceptions() {
    }

    static final String TYPE_ERROR_MESS = "[ERROR] 숫자로만 입력해 주세요.";
    static final String POSITIVE_ERROR_MESS = "[ERROR] 양수로만 입력해 주세요.";
    static final String DIVISIBLE_1000_MESS = "[ERROR] 로또 하나 당 금액은 1,000원 입니다. 1,000 단위로 작성해주세요. (ex. 13개 구입 시, 13000 으로 입력)";

    public static void exceptionNotInt() {
        System.out.println(TYPE_ERROR_MESS);
    }

    public static void execptionNotPositive() {
        System.out.println(POSITIVE_ERROR_MESS);
    }

    public static void exceptionNotDivisible1000() {
        System.out.println(DIVISIBLE_1000_MESS);
    }
}

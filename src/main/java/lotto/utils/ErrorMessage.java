package lotto.utils;

public class ErrorMessage {
    private static final int MINIMUM_LOTTO_PRICE = 1000;
    private static final String NOT_A_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String INVALID_MINIMUM_LOTTO_PRICE = "[ERROR] " + MINIMUM_LOTTO_PRICE + "원 이상의 금액만 입력 가능합니다.";
    private static final String INDIVISIBLE_LOTTO_PRICE = "[ERROR] 금액은 " + MINIMUM_LOTTO_PRICE + "단위만 가능합니다.";
    private static final String INVALID_LOTTO_NUMBER_LENGTH = "[ERROR] 당첨 번호의 길이는 쉼표로 구분된 6자리 입니다.";
    private static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 당첨 번호의 범위는 1부터 45까지의 숫자입니다.";
    private static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복이 허용되지 않습니다.";

    public static void numberException() {
        System.out.println(NOT_A_NUMBER);
    }

    public static void minimumLottoPriceException() {
        System.out.println(INVALID_MINIMUM_LOTTO_PRICE);
    }

    public static void indivisibleLottoPriceException() {
        System.out.println(INDIVISIBLE_LOTTO_PRICE);
    }

    public static void lottoNumberLengthException() {
        System.out.println(INVALID_LOTTO_NUMBER_LENGTH);
    }

    public static void lottoNumberRangeException() {
        System.out.println(INVALID_LOTTO_NUMBER_RANGE);
    }

    public static void lottoNUmberDuplicationException() {
        System.out.println(DUPLICATE_LOTTO_NUMBER);
    }
}

package lotto.exception;

public final class ExceptionHandler {
    public final static String NOT_DIVISIBLE = "[ERROR] 1,000원으로 나누어 떨어지지 않습니다.";
    public final static String NOT_NUMERIC = "[ERROR] 구입금액은 0보다 큰 정수 값이어야 합니다.";
    public final static String OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public final static String NO_LENGTH_OF_SIX = "[ERROR] 당첨 번호는 6개를 뽑아야 합니다.";
    public final static String NUMBER_IN_DUPLICATE = "[ERROR] 중복되지 않는 숫자 6개를 뽑아야 합니다.";
    public final static String NO_LENGTH_OF_ONE = "[ERROR] 보너스 번호는 1개를 뽑아야 합니다.";
    public final static String DIFFERENT_BUY_FROM_PUBLISH = "[ERROR] 구매한 로또 수와 발행한 로또 수가 다릅니다.";


    public static void invalidPriceType() {
        System.out.println(NOT_NUMERIC);
    }

    public static void notDivisibleBy1000() {
        throw new IllegalArgumentException(NOT_DIVISIBLE);
    }

    public static void notBetween1And45() {
        throw new IllegalArgumentException(OUT_OF_RANGE);
    }

    public static void noLengthOfSix() {
        throw new IllegalArgumentException(NO_LENGTH_OF_SIX);
    }

    public static void noLengthOfOne() {
        throw new IllegalArgumentException(NO_LENGTH_OF_ONE);
    }

    public static void numberInDuplicate() {
        throw new IllegalArgumentException(NUMBER_IN_DUPLICATE);
    }

    public static void differentBuyFromPublish() {
        throw new IllegalStateException(DIFFERENT_BUY_FROM_PUBLISH);
    }
}

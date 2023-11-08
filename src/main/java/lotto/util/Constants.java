package lotto.util;

public class Constants {
    public static final char LINE = '\n';
    public static final int ZERO = 0;
    public final static int THOUSAND = 1000;
    public static final int LOTTO_LENGTH = 6;
    public final static String ERROR = "[ERROR] ";
    public static final int MAX_NUMBER = 45;

    private Constants(){
        throw new AssertionError(ERROR+"생성할 수 없는 클래스입니다.");
    }
}

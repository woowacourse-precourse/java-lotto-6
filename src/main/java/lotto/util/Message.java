package lotto.util;

public class Message {
    private static String prefixMessage = "[ERROR] ";

    public final static String EXCPTION_NOT_A_NUM = prefixMessage + "로또 번호는 숫자만 입력 가능합니다.";
    public static final String EXCPTION_LESS_THAN_THOUSNAD = prefixMessage + "1,000 이상의 값을 입력해주세요.";
    public static final String EXCPTION_DIVIDE_INTO_THOUSNAD = prefixMessage + "입력 값은 1,000으로 나누어 떨어져야합니다.";
    public static final String EXCPTION_NOT_A_SIX = prefixMessage + "로또 번호는 6개여야 합니다.";
    public static final String EXCPTION_DUPLICATED = prefixMessage + "로또 번호는 중복기입될 수 없습니다.";
}
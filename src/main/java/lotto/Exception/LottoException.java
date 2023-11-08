package lotto.Exception;

public class LottoException {

    private final static String notNumberMessage = "[ERROR] 입력이 숫자여야 합니다.";
    private final static String notThousandMessage = "[ERROR] 금액은 1000원으로 나눠 떨어져야 합니다.";

    public void notNumber() {
        throw new IllegalArgumentException(notNumberMessage);
    }

    public void notThousand() {
        throw new IllegalArgumentException(notThousandMessage);
    }
}

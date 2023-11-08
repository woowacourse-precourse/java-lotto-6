package lotto.Exception;

public class LottoException {

    private final static String notNumberMessage = "[ERROR] 입력이 숫자여야 합니다.";
    private final static String notThousandMessage = "[ERROR] 금액은 1000원으로 나눠 떨어져야 합니다.";
    private final static String notSixLottoNumberMessage = "[ERROR] 로또 번호는 6개 입력해야 합니다.";
    private final static String notLottoNumberMessage = "[ERROR] 로또 번호는 1~45 사이로 입력해야 합니다.";
    private final static String duplicationLottoNumberMessage = "[ERROR] 로또 번호는 중복 없이 입력해야 합니다.";

    public void notNumber() {
        throw new IllegalArgumentException(notNumberMessage);
    }

    public void notThousand() {
        throw new IllegalArgumentException(notThousandMessage);
    }

    public void notSixLottoNumber() {
        throw new IllegalArgumentException(notSixLottoNumberMessage);
    }

    public void notLottoNumber() {
        throw new IllegalArgumentException(notLottoNumberMessage);
    }

    public void duplicationLottoNumber() {
        throw new IllegalArgumentException(duplicationLottoNumberMessage);
    }

}

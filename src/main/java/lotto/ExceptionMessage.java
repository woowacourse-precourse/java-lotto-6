package lotto;

public class ExceptionMessage {
    public static final String INVALID_SIZE = "허용되는 로또 숫자 개수는 " + LottoOption.LOTTO_SIZE + "입니다.";
    public static final String OUT_OF_RANGE_LOTTO_NUMBER = "범위에서 벗어난 로또 숫자가 있습니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "중복되는 숫자가 포함되어 있습니다.";

    private ExceptionMessage() {
        // 불필요한 인스턴스 생성 방지
    }

}

package lotto;

public class LottoNumber {
    private static final String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";

    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validate(String bonusNumber) {
        if (isInvalidType(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidType(String target) {
        try {
            Integer.parseInt(target);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}

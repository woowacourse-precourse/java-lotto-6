package lotto;

public class LottoMoney {
    private enum ErrorMessage {
        WRONG_TYPE("[ERROR] 로또 구매금액의 타입은 숫자여야 합니다."),
        WRONG_AMOUNT("[ERROR] 로또 구매금액은 1000단위 숫자여야 합니다."),
        WRONG_PRICE("[ERROR] 최소 로또 구매금액은 1,000원 입니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private double lottoMoney;
    private int lottoTiket;

    public LottoMoney(String inputMoney) {
        validate(inputMoney);
        int lottoMoney = Integer.valueOf(inputMoney);
        this.lottoMoney = lottoMoney;
        this.lottoTiket = lottoMoney / 1000;
    }

    private void validate(String inputMoney) {
        if (!isNumber(inputMoney)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        } else if (!isTousandMoney(Integer.valueOf(inputMoney))) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_AMOUNT.getMessage());
        } else if (isZeroMoney(Integer.valueOf(inputMoney))) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRICE.getMessage());
        }
    }

    private boolean isNumber(String inputMoney) {
        return inputMoney.matches("\\d+");
    }

    private boolean isTousandMoney(int inputMoney) {
        return inputMoney % 1000 == 0;
    }

    private boolean isZeroMoney(int inputMoney) {
        return Integer.valueOf(inputMoney) <= 0;
    }

    public double getLottoMoney() {
        return lottoMoney;
    }

    public int getLottoTicket() {
        return lottoTiket;
    }

}

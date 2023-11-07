package lotto;

public class LottoMoney {
    private static final String WRONG_TYPE_LOTTO_MONEY_MESSAGE = "[ERROR] 로또 구매금액의 타입은 숫자여야 합니다.";
    private static final String WRONG_LOTTO_MONEY_MESSAGE = "[ERROR] 로또 구매금액은 1000단위 숫자여야 합니다.";
    private double lottoMoney;
    private int lottoTiket;

    public LottoMoney(String inputMoney) {
        validate(inputMoney);
        int lottoMoney = Integer.valueOf(inputMoney);
        this.lottoMoney = lottoMoney;
        this.lottoTiket = lottoMoney / 1000;
    }

    private void validate(String inputMoney) {
        if (!inputMoney.matches("\\d+")) {
            throw new IllegalArgumentException(WRONG_TYPE_LOTTO_MONEY_MESSAGE);
        } else if (Integer.valueOf(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException(WRONG_LOTTO_MONEY_MESSAGE);
        }
    }
}

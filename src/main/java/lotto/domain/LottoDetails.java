package lotto.domain;

public enum LottoDetails {

    LOTTO_NUMBER_MINIMUM(1),
    LOTTO_NUMBER_MAXIMUM(45),
    LOTTO_SIZE(6);

    private int value;

    LottoDetails(int value) {
        this.value = value;
    }

    public static int lottoNumberMinimum() {
        return LOTTO_NUMBER_MINIMUM.getValue();
    }

    public static int lottoNumberMaximum() {
        return LOTTO_NUMBER_MAXIMUM.getValue();
    }

    public static int lottoSize() {
        return LOTTO_SIZE.getValue();
    }

    private int getValue() {
        return value;
    }
}

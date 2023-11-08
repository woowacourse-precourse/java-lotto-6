package lotto;

public enum LottoConfig {
    LOTTO_LENGTH(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    PRICE(1000);

    private final Integer lottoConfig;

    LottoConfig(Integer lottoConfig) {
        this.lottoConfig = lottoConfig;
    }

    public Integer getLottoConfig() {
        return lottoConfig;
    }
}

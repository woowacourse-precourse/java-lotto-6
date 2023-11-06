package lotto.domain;

public enum LottoEnum {
    LOTTO_PRICE(1000);


    private final Integer status;

    LottoEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}

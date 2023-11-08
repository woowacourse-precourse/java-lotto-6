package lotto.domain;

public enum LottoServiceEnum {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6);

    private final Integer createLotto;

    LottoServiceEnum(Integer createLotto) {
        this.createLotto = createLotto;
    }

    public Integer getCreateLotto() {
        return createLotto;
    }
}

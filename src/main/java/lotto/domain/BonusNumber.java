package lotto.domain;

public class BonusNumber {

    private final Integer value;

    public BonusNumber(Integer value) {
        this.value = value;
    }

    public Integer toValue() {
        return value;
    }
    // 1~ 45 사이의 범위의 숫자인지 validate
}

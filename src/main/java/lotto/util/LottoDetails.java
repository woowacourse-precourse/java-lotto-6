package lotto.util;

/**
 * 로또 게임 내의 로또, 정답 번호에 관련된 상수를 관리한다.
 */
public enum LottoDetails {
    COUNT_OF_LOTTO_NUMBER(6),

    MINIMUM_OF_LOTTO_NUMBER(1),
    MAXIMUM_OF_LOTTO_NUMBER(45);

    private final Integer details;

    LottoDetails(Integer details) {
        this.details = details;
    }

    public Integer getDetails() {
        return details;
    }
}

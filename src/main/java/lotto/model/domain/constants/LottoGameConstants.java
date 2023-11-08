package lotto.model.domain.constants;

public enum LottoGameConstants {
    MIN_NUMBER(1), // 로또 최소범위
    MAX_NUMBER(45), // 로또 최대범위
    NUMBERS_PER_LOTTO(6), // 로또번호 개수
    PRICE_PER_LOTTO(1000), // 로또 1장당 금액
    BONUS_COUNT(1), // 보너스를 포함하는 당첨의 개수
    START_PRIZE(3); // 로또 상금 시작단위

    private final int value;

    LottoGameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

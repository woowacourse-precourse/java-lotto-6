package lotto.common.constants;

public enum LottoRule {
    PICK_HIT_NUMBER_TOTAL(6),
    PICK_BONUS_NUMBER_TOTAL(1),
    PICK_MIN_NUMBER(1),
    PICK_MAX_NUMBER(45),
    ONE_LOTTO_TICKET_PRICE(1000);

    private final int rule;

    LottoRule(int rule) {
        this.rule = rule;
    }

    public int getRule() {
        return rule;
    }

    // 숫자 몇개 뽑냐, 몇부터 몇까지냐, 가격이 얼마냐, 보너스 번호는 몇개 뽑냐
}

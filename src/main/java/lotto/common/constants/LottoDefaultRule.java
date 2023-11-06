package lotto.common.constants;

public enum LottoDefaultRule {
    PICK_HIT_NUMBER_TOTAL(6),
    PICK_BONUS_NUMBER_TOTAL(1),
    PICK_MIN_NUMBER(1),
    PICK_MAX_NUMBER(45),
    ONE_LOTTO_TICKET_PRICE(1000);

    private final int rule;

    LottoDefaultRule(int rule) {
        this.rule = rule;
    }

    public int getRule() {
        return rule;
    }
}

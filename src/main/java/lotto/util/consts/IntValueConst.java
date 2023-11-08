package lotto.util.consts;

public enum IntValueConst {
    SINGLE_LOTTO_PRICE(1000),
    START_INCLUSIVE_LOTTO_NUMBER(1),
    END_INCLUSIVE_LOTTO_NUMBER(45),
    LOTTO_FIXED_CIPHER(6),
    NEVER_COUNTED(0),
    TWO_LOTTO_CIPHERS(LOTTO_FIXED_CIPHER.getValue() * 2),
    MEMORY_SIZE_LIMIT(2100000000);

    private final int value;

    IntValueConst(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package lotto.domain;

enum LottoConstant {
    MIN(1),
    MAX(45);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

package lotto.enums;

public enum LottoSeparatorConstant {

    LOTTO_INPUT_SEPARATOR(",");

    private final String constant;

    LottoSeparatorConstant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
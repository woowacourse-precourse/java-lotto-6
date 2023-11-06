package lotto.utils;

public enum LottoConstant {
    SPACE(" "),
    NEW_LINE("\n"),
    DELIMITER(","),
    OPENING_BRACKET("["),
    CLOSING_BRACKET("]");

    private final String lottoConstant;

    LottoConstant(String lottoConstant) {
        this.lottoConstant = lottoConstant;
    }

    public String get() {
        return lottoConstant;
    }

    public String getWithSpace() {
        return lottoConstant + SPACE.get();
    }
}

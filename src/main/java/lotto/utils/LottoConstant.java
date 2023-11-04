package lotto.utils;

public enum LottoConstant {
    SPACE(" "),
    NEW_LINE("\n"),
    DELIMITER(","),
    OPENING_BRACKET("["),
    CLOSING_BRACKET("]");

    private String lottoConstant;

    LottoConstant(String lottoConstant) {
        this.lottoConstant = lottoConstant;
    }

    public String get() {
        return lottoConstant;
    }

    public String getLottoStringWithSpace() {
        return lottoConstant + SPACE.get();
    }
}

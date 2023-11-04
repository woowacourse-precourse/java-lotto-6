package lotto.utils;

public enum LottoConstant {
    SPACE(" "),
    DELIMITER(","),
    OPENING_BRACKET("["),
    CLOSING_BRACKET("]");

    private String lottoConstant;

    LottoConstant(String lottoConstant) {
        this.lottoConstant = lottoConstant;
    }

    public String getLottoConstant() {
        return lottoConstant;
    }

    public String getLottoStringWithSpace() {
        return lottoConstant + SPACE.getLottoConstant();
    }
}

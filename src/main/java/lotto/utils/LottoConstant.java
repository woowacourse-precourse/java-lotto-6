package lotto.utils;

public enum LottoConstant {
    SPACE(" "),
    NEW_LINE("\n"),
    DELIMITER(",");

    private final String lottoConstant;

    LottoConstant(String lottoConstant) {
        this.lottoConstant = lottoConstant;
    }

    public String get() {
        return lottoConstant;
    }
}

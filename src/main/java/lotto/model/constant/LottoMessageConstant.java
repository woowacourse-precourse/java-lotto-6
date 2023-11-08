package lotto.model.constant;

public enum LottoMessageConstant {

    START_BRACKET("["),
    NUMBER_DELIMITER(", "),
    END_BRACKET("]");

    private final String constant;

    LottoMessageConstant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}

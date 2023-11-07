package System;

public enum Phrase {

    RAFFLE_DELIMITER(","),
    RAFFLE_PATTERN("^\\d+(,\\d+){5}$");

    Phrase(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    private final String constant;
}

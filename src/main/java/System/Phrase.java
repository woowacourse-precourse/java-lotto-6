package System;

public enum Phrase {

    RAFFLE_DELIMITER(","),
    RAFFLE_WINNING_NUMBER_PATTERN("^\\d+(,\\d+){5}$"),
    RAFFLE_BONUS_NUMBER_PATTERN("\\d+");


    Phrase(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    private final String constant;
}

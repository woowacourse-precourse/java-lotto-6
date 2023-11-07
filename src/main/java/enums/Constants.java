package enums;

public enum Constants {

    NUMERIC_REGEX("^[1-9]\\d*$"),
    WINNING_NUMBER_SIZE("6");

    private final String constant;
    Constants(String constant) {
        this.constant = constant;
    }
    public String getConst(){
        return constant;
    }
}

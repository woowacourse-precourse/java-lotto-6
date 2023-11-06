package enums;

public enum Constants {

    NUMERIC_REGEX("^[1-9]\\d*$");

    private final String constant;
    Constants(String constant) {
        this.constant = constant;
    }
    public String getConst(){
        return constant;
    }
}

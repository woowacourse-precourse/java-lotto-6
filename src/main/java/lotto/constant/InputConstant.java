package lotto.constant;

public enum InputConstant {
    BLANK(" "),
    SEPERATOR(","),
    DASH("-");

    private final String value;

    InputConstant(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}

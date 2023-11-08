package lotto.global.enums;

public enum Separator {

    NONE(""),
    EMPTY_SPACE(" "),
    COMMA(","),
    NEW_LINE("\n"),
    OPENING_BRACKET("["),
    CLOSING_BRACKET("]");

    private final String separator;

    Separator (String separator){
        this.separator = separator;
    }

    @Override
    public String toString(){
        return separator;
    }

}

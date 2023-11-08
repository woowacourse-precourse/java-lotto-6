package lotto.utility.enums;

public enum RegularExpressionPatterns {
    VALID_IMPROPER_COMMA_POSITION_PATTERN("^(,.*|.*,,.*|.*,)$"),
    VALID_ONLY_NUMBERS("^[0-9]+$");

    private String pattern;

    RegularExpressionPatterns(String pattern){
        this.pattern = pattern;
    }

    public String getPattern(){
        return pattern;
    }
}

package lotto.utility.enums;

public enum RegularExpressionPatterns {
    VALID_IMPROPER_COMMA_POSITION_PATTERN("^(,.*|.*,,.*|.*,)$");

    private String pattern;

    RegularExpressionPatterns(String pattern){
        this.pattern = pattern;
    }

    public String getPattern(){
        return pattern;
    }
}

package lotto.config;

import java.util.regex.Pattern;

public enum RegexPattern {
    ONLY_NUMBER_REGEX_PATTERN("[0-9]+"),
    LOTTO_WINNING_NUMBER_REGEX_PATTERN("^([0-9]+(,[0-9]+)+)$");

    private final String pattern;

    RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
    
}

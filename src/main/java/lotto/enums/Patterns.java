package lotto.enums;

import java.util.regex.Pattern;

public enum Patterns {

    AMOUNT_CHECK_PATTERN(RegexPattern.AMOUNT_CHECK.getPattern()),
    LOTTO_NUMBERS_CHECK(RegexPattern.LOTTO_NUMBERS_CHECK.getPattern()),
    LOTTO_BONUS_NUMBER_CHECK(RegexPattern.LOTTO_BONUS_NUMBER_CHECK.getPattern());
    private final Pattern pattern;

    Patterns(String pattern){
        this.pattern = Pattern.compile(pattern);
    }

    public Pattern getPattern() {
        return this.pattern;
    }
}

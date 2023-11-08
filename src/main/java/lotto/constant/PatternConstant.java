package lotto.constant;

import java.util.regex.Pattern;

public final class PatternConstant {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9][0-9]*");
    public static final Pattern HAS_COMMAS_WITHOUT_SURROUNDING_VALUES_PATTERNS = Pattern.compile("^\\s*,|,\\s*,|,\\s*$");

}

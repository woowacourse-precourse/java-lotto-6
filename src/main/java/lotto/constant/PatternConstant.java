package lotto.constant;

import java.util.regex.Pattern;

public final class PatternConstant {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("(\\+|-)?[0-9]+");
    public static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("\\+?[1-9][0-9]*");
    public static final Pattern TRUE_PATTERN = Pattern.compile("true");
    public static final Pattern FALSE_PATTERN = Pattern.compile("false");
    public static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z]([0-9]|[a-zA-Z]|_)*");
    public static final Pattern HAS_COMMAS_WITHOUT_SURROUNDING_VALUES_PATTERNS = Pattern.compile("^,|,$|[^,],,[^,]");
}

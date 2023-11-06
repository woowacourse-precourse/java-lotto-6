package lotto.resource;


import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TextFormat {
    private static final String stringIdentifier = "%s";
    private final String format;
    private final List<String> tokens;
    private final Pattern pattern;

    public TextFormat(String format) {
        this.format = format;
        this.tokens = makeTokens(format);
        this.pattern = makePattern(format);
    }

    private static List<String> makeTokens(String format) {

        return Arrays.stream(format.split("%s", -1))
                .collect(toList());
    }

    private static Pattern makePattern(String format) {
        String pattern = format.replace("[", "\\[");
        pattern = pattern.replace("]", "\\]");
        pattern = pattern.replace("(", "\\(");
        pattern = pattern.replace(")", "\\)");
        pattern = pattern.replace("%s", ".{1,}");
        return Pattern.compile(pattern);
    }

    public boolean matches(String target) {
        return pattern.asMatchPredicate().test(target);
    }

    public String format(String... arguments) {
        if (arguments.length < tokens.size() - 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder();
        builder.append(tokens.get(0));

        for (int i = 0; i < tokens.size() - 1; i++) {
            builder.append(arguments[i]);
            builder.append(tokens.get(i + 1));
        }

        return builder.toString();
    }

    public List<String> parse(String target) {
        if (!pattern.matcher(target).matches()) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();

        int cur = target.indexOf(tokens.get(0));
        for (int i = 0; i < tokens.size() - 1; i++) {
            int from = cur + tokens.get(i).length();
            int to = target.indexOf(tokens.get(i + 1), from+1);
            result.add(target.substring(from , to));
            cur = to;
        }
        return result;
    }
}

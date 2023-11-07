package lotto.util;

import java.text.DecimalFormat;

public class TextBuilder {
    private StringBuilder stringBuilder;

    private TextBuilder(String text) {
        this.stringBuilder = new StringBuilder(text);
    }

    public static TextBuilder fromString(String text) {
        return new TextBuilder(text);
    }

    public TextBuilder append(String text) {
        stringBuilder.append(text);
        return this;
    }

    public TextBuilder appendInteger(Integer number) {
        stringBuilder.append(number);
        return this;
    }

    public TextBuilder appendDouble(Double number) {
        stringBuilder.append(number);
        return this;
    }

    public TextBuilder appendLineSeparator() {
        stringBuilder.append(System.lineSeparator());
        return this;
    }

    public String build() {
        return stringBuilder.toString();
    }
}

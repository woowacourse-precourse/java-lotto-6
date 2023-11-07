package lotto.converter;

import java.text.DecimalFormat;

public class YieldFormatConverter implements Converter<String, Double> {

    private static final String YIELD_PATTERN = "#,##0.0";

    @Override
    public String convert(final Double source) {
        DecimalFormat yieldFormat = new DecimalFormat(YIELD_PATTERN);
        return String.join("", yieldFormat.format(source), "%");
    }

}

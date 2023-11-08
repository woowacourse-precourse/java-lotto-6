package lotto.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";
    private static final String MONEY_CURRENCY_PATTERN = "###,###";
    private static final String PROFIT_CURRENCY_PATTERN = "###,##0.0";
    private final LottoValidator lottoValidator;

    public Parser(LottoValidator lottoValidator) {
        this.lottoValidator = lottoValidator;
    }

    public List<Integer> parseNumbers(String input) {
        String[] numbers = input.split(DELIMITER);
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(this::convertToInt)
                .toList();
    }

    private Integer convertToInt(String number) {
        return lottoValidator.validateNonNumeric(number);
    }

    public static String formatCurrency(BigDecimal amount, String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(amount);
    }

    public static String formatMoneyCurrency(BigDecimal amount) {
        return formatCurrency(amount, MONEY_CURRENCY_PATTERN);
    }

    public static String formatProfitCurrency(BigDecimal amount) {
        return formatCurrency(amount, PROFIT_CURRENCY_PATTERN);
    }

}

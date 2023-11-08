package lotto.global;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class Utils {
    public static final Pattern NUMBER_CHECK_PATTERN = Pattern.compile("^[0-9]+$");
    public static final Pattern WINNING_NUMBER_CHECK_PATTERN = Pattern.compile("^[0-9,]+$");
    public static final NumberFormat NUMBER_FORMAT_US = NumberFormat.getNumberInstance(Locale.US);
    public static final String SECOND_DECIMAL_PLACE_FORMAT = "%.1f";

    public static void checkNumber(String input) {
        if (!NUMBER_CHECK_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_INPUT_NUMBER.getMessage());
        }
    }

    public static double roundNumberBySecondDecimalPlace(double rewardRatio) {
        return Double.parseDouble(String.format(SECOND_DECIMAL_PLACE_FORMAT, rewardRatio));
    }
}

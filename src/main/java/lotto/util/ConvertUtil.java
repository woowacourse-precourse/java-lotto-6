package lotto.util;

public class ConvertUtil {
    private static final String DELIMITER = ",";
    public static String[] convertInputToLottoNumbers(String input) {
        return input.split(DELIMITER);
    }
}

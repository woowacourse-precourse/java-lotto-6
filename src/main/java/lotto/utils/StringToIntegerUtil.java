package lotto.utils;

public class StringToIntegerUtil {

    public int stringToMoney(String input) {
        if (containsThousandSeparator(input)) {
            input = removeComma(input);
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean containsThousandSeparator(String input) {
        return input.contains(",");
    }

    private String removeComma(String input) {
        return input.replace(",", "");
    }


}

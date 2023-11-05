package lotto;

public class LottoParser {
    public static int readLineToNumber(String readLine) {
        int number;
        try {
            number = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.PURCHASE_PRICE_NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage()
            );
        }
        return number;
    }
}

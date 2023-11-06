package lotto.model;
import java.util.Arrays;

import lotto.Lotto.LottoConstants;

public class validator {

    private static final int LOTTO_PRICE = LottoConstants.LOTTO_PRICE.getPrice();
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static void isValidLottoPurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
        }
    }

    private static void isSeparatedByCommas(String input){
        String[] parts = input.split(",");
        if (parts.length <= 1) {
            throw new IllegalArgumentException("[ERROR] 입력값은 쉼표로 구분된 6개의 숫자여야합니다.");
        }
    }

    private static void isValidLottoNumbersLength(String input){
        String[] numbers = input.split(",");
        if (numbers.length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 입력값은 " + LOTTO_NUMBERS_COUNT + "개의 숫자여야 합니다.");
        }
    }

    private static void isSixUniqueNumbers(String[] input){
        if (Arrays.stream(input).distinct().count() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 모든 숫자는 유니크해야 합니다.");
        }
    }

    private static void isValidNumbers(String[] input){
        for (String numberStr : input) {
            if (!numberStr.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 모든 입력값은 숫자로 이루어져야 합니다: " + numberStr);
            }
            int number = Integer.parseInt(numberStr);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 사이여야 합니다: " + numberStr);
            }
        }
    }




    public static void validateLottoNumbers(String input) {
        isSeparatedByCommas(input);
        isValidLottoNumbersLength(input);
        String[] numberStrings = input.split(",");
        isSixUniqueNumbers(numberStrings);
        isValidNumbers(numberStrings);
    }



    public static boolean validatePurchaseInput(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            isValidLottoPurchaseAmount(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다. (" + e.getMessage() + ")");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return false;
        }
        return true;
    }
}

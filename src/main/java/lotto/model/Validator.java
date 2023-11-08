package lotto.model;
import static lotto.view.View.ERROR_PREFIX;
import java.util.List;

import lotto.Lotto.LottoConstants;
import lotto.view.View.ErrorMessage;

public class Validator {

    private static final int LOTTO_PRICE = LottoConstants.LOTTO_PRICE.getPrice();
    private static final int LOTTO_NUMBERS_COUNT = 6;


    // input값이 1 이상의 양의 정수인지 판별하는 로직
    public static void isPositiveInteger(String input){
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.NOT_POSITIVE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    // 사용자로부터 로또 구매비용을 입력받아 로또 구매가 가능한 금액인지 검사하는 로직
    private static void isValidLottoPurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.BELOW_MINIMUM_AMOUNT.getMessage());
        }
    }

    // 총 6개의 숫자가 들어있는지 확인하는 로직
    private static void isIncludeSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INCORRECT_NUMBER_COUNT.getMessage());
        }
    }

    // 모든 숫자가 유니크한지 확인하는 로직 (종복이 없는지 검사하는 로직)
    private static void isAllUniqueNumbers(List<Integer> input){
        if (input.stream().distinct().count() != input.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    // 입력받은 숫자가 1부터 45사이에 들어있는지 확인하는 로직
    private static void isWithinOneToFortyFive(List<Integer> input) {
        for (Integer number : input) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_RANGE.getMessage());
            }
        }
    }



    // 유저가 입력한 6개의 당첨번호가 유효하게 입력되었는지 검사하는 로직
    public static void validateWinningNumbers(String input) {
        List<Integer> integerList = LottoGame.convertInputToIntegerList(input);
        isIncludeSixNumbers(integerList);
        isAllUniqueNumbers(integerList);
        isWithinOneToFortyFive(integerList);
    }

    public static void validatePurchaseInput(String input) {
        isPositiveInteger(input);
        int purchaseAmount = Integer.parseInt(input);
        isValidLottoPurchaseAmount(purchaseAmount);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_RANGE.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}

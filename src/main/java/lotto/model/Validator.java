package lotto.model;
import java.util.Arrays;
import java.util.List;

import lotto.Lotto.LottoConstants;

public class Validator {

    private static final int LOTTO_PRICE = LottoConstants.LOTTO_PRICE.getPrice();
    private static final int LOTTO_NUMBERS_COUNT = 6;


    // input값이 1 이상의 양의 정수인지 판별하는 로직
    public static void isPositiveInteger(String input){
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                throw new IllegalArgumentException("[ERROR] 입력값은 1 이상의 정수여야 합니다: " + input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자로만 구성되어야 합니다: " + input, e);
        }
    }

    // 사용자로부터 로또 구매비용을 입력받아 로또 구매가 가능한 금액인지 검사하는 로직
    private static void isValidLottoPurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
        }
    }

    // 총 6개의 숫자가 들어있는지 확인하는 로직
    private static void isIncludeSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 입력값은 " + LOTTO_NUMBERS_COUNT + "개의 숫자여야 합니다.");
        }
    }

    // 모든 숫자가 유니크한지 확인하는 로직 (종복이 없는지 검사하는 로직)
    private static void isAllUniqueNumbers(List<Integer> input){
        if (input.stream().distinct().count() != input.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 존재해선 안됩니다.");
        }
    }

    // 입력받은 숫자가 1부터 45사이에 들어있는지 확인하는 로직
    private static void isWithinOneToFortyFive(List<Integer> input) {
        for (Integer number : input) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 사이여야 합니다: " + number);
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
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이여야 합니다: " + bonusNumber);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 숫자와 중복됩니다: " + bonusNumber);
        }
    }
}

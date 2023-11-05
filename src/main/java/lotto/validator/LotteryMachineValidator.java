package lotto.validator;

import lotto.message.ErrorMessageFormatter;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessageFormatter.*;

public class LotteryMachineValidator {
    /**
     * - 당첨번호 입력을 검사한다.
     *      - 당첨번호가 O,O,O,O,O,O 의 형식을 지키고 있는가?
     *      - 정수가 입력되었는가?
     *      - 당첨번호가 범위를 지키고 있는가? (1 ~ 45)
     * - 보너스 번호 입력을 검사한다.
     *      - 뽑은 보너스 번호가 당첨번호와 겹치는 지 확인
     *      - 뽑은 보너스 번호가 정수인가?
     *      - 뽑은 보너스 번호가 범위안에 속하는 정수인지 검증
     */

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int LOTTERY_LENGTH = 6;

    public static final String LUCKY_NUMBER_FORMAT_MESSAGE = "당첨 번호는 ','로 구분되어 입력해야 합니다.";
    public static final String LUCKY_NUMBER_NOT_INTEGER_MESSAGE = "당첨 번호는 정수만 입력할 수 있습니다.";
    public static final String LUCKY_NUMBER_OUT_OF_RANGE_MESSAGE = "당첨 번호는 " + MIN_RANGE + "이상, " + MAX_RANGE + "이하의 숫자가 입력되어야 합니다.";

    public static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "당첨번호와 보너스번호는 중복 불가";
    public static final String BONUS_NUMBER_NOT_INTEGER_MESSAGE = "보너스 번호는 정수가 입력되어야 합니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE_MESSAGE = "보너스 번호는 " + MIN_RANGE + "이상, " + MAX_RANGE + "이하의 숫자가 입력되어야 합니다.";

    private LotteryMachineValidator() {
    }

    public static void validateLuckyNumber(final String input) {
        validateLuckyNumberFormat(input);
        validateLuckyNumberInteger(input);
        validateLuckyNumberRange(input);
    }

    private static void validateLuckyNumberFormat(final String input) {
        String[] split = input.split(",");
        if (split.length != LOTTERY_LENGTH) {
            throw new IllegalArgumentException(LUCKY_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void validateLuckyNumberInteger(String input) {
        String[] split = input.split(",");
        for (String str : split) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(makeErrorMessageWith(LUCKY_NUMBER_NOT_INTEGER_MESSAGE))
            }
        }
    }

    private static void validateLuckyNumberRange(String input) {
        String[] split = input.split(",");
        List<Integer> numbers = Arrays.stream(split)
            .map(Integer::parseInt)
            .toList();

        for (Integer number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException(makeErrorMessageWith(LUCKY_NUMBER_OUT_OF_RANGE_MESSAGE));
            }
        }
    }

    public static void validateBonusNumber(List<Integer> luckyNumbers, String input) {
        validateBonusNumberInteger(input);
        validateBonusNumberDuplicated(luckyNumbers, input);
        validateBonusNumberRange(input, MIN_RANGE, MAX_RANGE);
    }


    private static void validateBonusNumberInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_INTEGER_MESSAGE);
        }
    }

    private static void validateBonusNumberDuplicated(List<Integer> luckyNumbers, String input) {
        int number = Integer.parseInt(input);
        if (luckyNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
    }

    private static void validateBonusNumberRange(String input, int min, int max) {
        int number = Integer.parseInt(input);
        if (number < min || number > max) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_MESSAGE);
        }
    }

}

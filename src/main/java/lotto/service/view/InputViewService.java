package lotto.service.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validator;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessageType.*;

/**
 * @Class : 로또 관리 UI 입력 클래스
 */
public class InputViewService {

    public static int inputAmount(int lottoPrice) {
        int amount = ConvertStringToInt(getInputData());
        if (!Validator.isMultipleOfNumber(amount, lottoPrice)) {
            throw new IllegalArgumentException(ERROR_MIN_LOTTO_AMOUNT_UNIT.getLottoMessage());
        }
        return amount;
    }

    public static Lotto inputWinnigNumbers(int lottoStatNumber, int lottoEndNumber, int lottoCount) {
        List<Integer> winnigNumbers = ConvertStringToIntList(getInputData());
        rangeValidation(winnigNumbers, lottoStatNumber, lottoEndNumber);
        countValidation(winnigNumbers, lottoCount);
        duplicateValidation(winnigNumbers);
        return new Lotto(winnigNumbers);
    }

    public static int inputBonusNumber(List<Integer> numbers, int lottoStatNumber, int lottoEndNumber) {
        int bonusNumber = ConvertStringToInt(getInputData());
        betweenValidation(bonusNumber, lottoStatNumber, lottoEndNumber);
        containValidation(bonusNumber, numbers);
        return bonusNumber;
    }

    private static String getInputData() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    private static void rangeValidation(List<Integer> numberList, int start, int end) {
        if (!Validator.isBetweenValue(numberList, start, end)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER.getLottoMessage());
        }
    }

    private static void countValidation(List<Integer> numberList, int count) {
        if (!Validator.isListSizeEquals(numberList, count)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_SIZE.getLottoMessage());
        }
    }

    private static void duplicateValidation(List<Integer> numberList) {
        if (Validator.isDuplicateValue(numberList)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER.getLottoMessage());
        }
    }

    private static void betweenValidation(int bonusNumber, int start, int end) {
        if (!Validator.isBetween(bonusNumber, start, end)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER.getLottoMessage());

        }
    }

    private static void containValidation(int number, List<Integer> numbers) {
        if (Validator.isContainNumber(numbers, number)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER.getLottoMessage());
        }
    }

    private static List<Integer> ConvertStringToIntList(String inputData) {
        return splitAndTrim(inputData, ",");
    }

    private static int ConvertStringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT.getLottoMessage());
        }
    }

    private static List<Integer> splitAndTrim(String target, String splitRegex) {
        return Arrays.stream(target.split(splitRegex))
                .map(String::trim)
                .map(InputViewService::ConvertStringToInt)
                .collect(Collectors.toList());
    }
}

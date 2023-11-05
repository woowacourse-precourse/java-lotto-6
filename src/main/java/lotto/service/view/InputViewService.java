package lotto.service.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validator;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessageType.*;

/**
 * @Class : 로또 관리 UI 서비스 클래스
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
        List<Integer> winnigNumbers =  ConvertStringToIntList(getInputData());

        rangeValidation(winnigNumbers, lottoEndNumber, lottoStatNumber);
        countValidation(winnigNumbers, lottoCount);
        duplicateValidation(winnigNumbers);

        return new Lotto(winnigNumbers);
    }

    public static int inputBonusNumber() {
        return 0;
    }

    private static String getInputData() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    private static void rangeValidation(List<Integer> winnigNumbers, int lottoStatNumber, int lottoEndNumber) {
        if(!Validator.isBetweenValue(winnigNumbers, lottoStatNumber, lottoEndNumber)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER.getLottoMessage());
        }
    }

    private static void countValidation(List<Integer> winnigNumbers, int lottoCount) {
        if(!Validator.isListSizeEquals(winnigNumbers, lottoCount)){
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_SIZE.getLottoMessage());
        }
    }

    private static void duplicateValidation(List<Integer> winnigNumbers) {
        if (Validator.isDuplicateValue(winnigNumbers)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER.getLottoMessage());
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

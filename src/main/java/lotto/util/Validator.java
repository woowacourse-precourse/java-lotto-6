package lotto.util;

import lotto.configure.InputConfiguration;
import lotto.configure.DomainConfiguration;
import lotto.configure.ErrorMessages;

import java.util.Arrays;
import java.util.List;

/**
 * 값을 검증하는 클래스.
 * 값이 올바르지 않을 경우 예외를 발생시킨다.
 */
public class Validator {

    /**
     * 주어진 문자열이 정수를 나타내는지 검증한다.
     * " 123"과 같이 공백을 포함하는 경우에도 예외를 발생시킨다.
     * @param toValidate 정수인지 검증할 문자열
     * @throws IllegalArgumentException toValidate가 정수를 나타내는 문자열이 아닐 경우 발생한다.
     */
    public static void checkIfInteger(String toValidate) throws IllegalArgumentException {
        try {
            Integer.parseInt(toValidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_AN_INTEGER.get());
        }
    }

    /**
     * 주어진 숫자가 0 이상의 숫자인지 검증한다.
     * numToValidate >= 0인 경우 예외를 발생시킨다.
     * @param numToValidate 검증할 정수.
     * @throws IllegalArgumentException numToValidate >= 0인 경우 발생한다.
     */
    public static void checkIfNonNegative(int numToValidate) throws IllegalArgumentException {
        if (numToValidate < 0) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_NUMBER_IS_NEGATIVE.get());
        }
    }

    /**
     * 주어진 숫자가 1000의 배수인지 검증한다.
     * 다시 말해, numToValidate % 1000 == 0인지 검증한다.
     * @param numToValidate 검증할 정수.
     * @throws IllegalArgumentException numToValidate가 1000의 배수가 아닐 경우 발생한다.
     */
    public static void checkIfMultipleOfThousand(int numToValidate) throws IllegalArgumentException {
        if (!isMultipleOfThousand(numToValidate)) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_NUMBER_IS_NOT_MULTIPLE_OF_1000.get());
        }
    }

    private static boolean isMultipleOfThousand(int num) {
        return num % 1000 == 0;
    }

    /**
     * 당첨 번호의 사용자 입력이 오직 정수와 InputConfiugraion에 정의된 demlimiter로만 이루어졌는지 검증한다.
     * @param winningNumbersInput 검증할 사용자 입력 문자열.
     * @throws IllegalArgumentException winningNumbersInput이 공백이나 미리 지정된 delimiter나 정수가 아닌 문자를 포함할
     *                                  경우 발생한다.
     */
    public static void checkIfWinningNumbersAreInteger(String winningNumbersInput) throws IllegalArgumentException {
        Arrays.asList(winningNumbersInput.split(InputConfiguration.DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER))
                .forEach(Validator::checkIfInteger);
    }

    /**
     * 당첨 번호가 총 6개인지 검증한다.
     * winningNumbers의 사이즈가 정확히 6이 아닐 경우 예외가 발생한다.
     * @param winningNumbers 당첨 번호가 담긴 리스트.
     * @throws IllegalArgumentException winningNumbers.size() != 6일 경우 발생한다.
     */
    public static void checkIfWinningNumbersAreSix(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBERS_ARE_NOT_SIX.get());
        }
    }

    /**
     * 개별 당첨 번호가 적절한 범위에 포함되는지 검증한다.
     * 당첨 번호의 최댓값과 최솟값은 각각 lotto.configure.LottoConfigure 클래스에 정의된 두 상수,
     * LOTTO_NUMBER_MAX, LOTTO_NUMBER_MIN이다.
     * @param winningNumbers 당첨 번호가 담긴 리스트.
     * @throws IllegalArgumentException 단 하나의 번호라도 로또 번호 범위에 포함되지 않을 경우 발생한다.
     */
    public static void checkRangeOfEachWinningNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        winningNumbers.forEach((n) ->
                checkIfRangeOfNumberIsProper(n, ErrorMessages.WINNING_NUMBERS_NOT_IN_PROPER_RANGE.get()));
    }

    /**
     * 보너스 번호가 적절한 범위에 포함되는지 검증한다.
     * 보너스 번호의 최댓값과 최솟값은 각각 lotto.configure.LottoConfigure 클래스에 정의된 두 상수,
     * LOTTO_NUMBER_MAX, LOTTO_NUMBER_MIN이다.
     * @param bonusNumber 검증할 보너스 번호.
     * @throws IllegalArgumentException 보너스 번호가 로또 번호 범위에 포함되지 않을 경우 발생한다.
     */
    public static void checkRangeOfBonusNumber(Integer bonusNumber) throws IllegalArgumentException {
        checkIfRangeOfNumberIsProper(bonusNumber, ErrorMessages.BONUS_NUMBER_NOT_IN_PROPER_RANGE.get());
    }

    private static void checkIfRangeOfNumberIsProper(Integer winningNumber, String errorMessage)
            throws IllegalArgumentException {
        if (isNumberOverRange(winningNumber) || isNumberBelowRange(winningNumber)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isNumberOverRange(Integer winningNumber) {
        return winningNumber > DomainConfiguration.LOTTO_NUMBER_MAX;
    }

    private static boolean isNumberBelowRange(Integer winningNumber) {
        return winningNumber < DomainConfiguration.LOTTO_NUMBER_MIN;
    }
}

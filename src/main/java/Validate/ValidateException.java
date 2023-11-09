package Validate;

import lotto.constant.ValidateConstant;
import lotto.utill.Utii;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException {
    private static final String KOREAN_ENGLISH_REGEX = ".*[^0-9\\s].*";
    private static final String KOREAN_ENGLISH_EXCEPTION_COMMA_REGEX = ".*[^0-9,\\s-].*";
    private static final String NOTING_STRING = "";
    private static final String BLANK = " ";
    private static final Character COMMA_CHAR = ',';
    private static final Integer POSITIVE_CONDITION_ZERO = 0;
    private static final Integer ZERO_NUM = 0;
    private static final Integer SIZE_WIN_NUMBERS_HOST = 6;
    private static final Integer MIN_WIN_NUMBERS = 1;
    private static final Integer MAX_WIN_NUMBERS = 45;
    private static final Integer START_BONUS_NUMBER = 1;
    private static final Integer END_BONUS_NUMBER = 45;
    private static final String SEQUENCE_COMMA = ",,";
    private static final char CHAR_DASH = '-';
    // ================== 유저 ==================
    private static final Integer BASIC_LOTTO_PRICE = 1000;

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException(ValidateConstant.ERROR_INCLUDE_STRING());
        }
    }

    public static void includeStringExceptionComma(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_EXCEPTION_COMMA_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException(ValidateConstant.ERROR_INCLUDE_STRING_EXCEPTION_COMMA());
        }
    }

    public static void commaStartAndEnd(String strLine) {
        int length = strLine.length();

        if (strLine.charAt(length - 1) == COMMA_CHAR || strLine.charAt(0) == COMMA_CHAR) {
            throw new NumberFormatException(ValidateConstant.ERROR_COMMA_START_END());
        }
    }

    public static void hasConsecutiveEmptyValues(String strLine) {
        if (strLine.contains(SEQUENCE_COMMA)) {
            throw new IllegalArgumentException(ValidateConstant.ERROR_CONSECUTIVE_EMPTY_VALUES());
        }
    }

    public static Boolean blankCheck(String strLine) {
        if (!strLine.equals(NOTING_STRING)) {
            return true;
        }
        throw new NumberFormatException(ValidateConstant.ERROR_BLANK_CHECK());
    }

    public static void includeBlank(String strLine) {
        if (strLine.contains(BLANK)) {
            throw new NumberFormatException(ValidateConstant.ERROR_INCLUDE_BLANK());
        }
    }

    public static void negative(String strLine) {
        Integer inputNum = Integer.valueOf(strLine);
        if (inputNum < POSITIVE_CONDITION_ZERO) {
            throw new NumberFormatException(ValidateConstant.ERROR_INPUT_NEGATIVE());
        }
    }

    public static void zeroNumber(String strLine) {
        Integer inputNum = Integer.valueOf(strLine);

        if (inputNum == ZERO_NUM) {
            throw new NumberFormatException(ValidateConstant.ERROR_INPUT_ZERO_NUMBER());
        }
    }

    public static boolean containsNonNumericCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != CHAR_DASH && !Character.isWhitespace(c)) {
                throw new NumberFormatException(ValidateConstant.ERROR_INPUT_ONLY_NUMBER());
            }
        }
        return false;
    }

    public static boolean isMultipleOf1000(int amount) {
        if ((amount % BASIC_LOTTO_PRICE) == ZERO_NUM) {
            return true;
        }
        throw new IllegalArgumentException(ValidateConstant.ERROR_INPUT_1000_WON_UNIT());
    }

    public static boolean isInRangeBonusNumber(int number) {
        if (number <= START_BONUS_NUMBER || number >= END_BONUS_NUMBER) {
            throw new IllegalArgumentException(ValidateConstant.ERROR_LOTTO_NUMBER_RANGE());
        }
        return false;
    }

    // ================== 로또 진행자 ==================
    public static boolean hasDuplicateEachNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer num : numbers) {
            if (!set.add(num)) {
                throw new IllegalArgumentException(ValidateConstant.ERROR_DUPLICATE_WIN_NUMBERS());
            }
        }

        return false;
    }

    public static boolean isWinNumbersCountSix(List<Integer> numbers) {
        Integer sizeNumbers = numbers.size();
        if (Utii.isSameInt(sizeNumbers, SIZE_WIN_NUMBERS_HOST)) {
            return true;
        }

        throw new IllegalArgumentException(ValidateConstant.ERROR_WIN_NUMBER_COUNT_SIX());
    }

    public static boolean checkRangeWinNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < MIN_WIN_NUMBERS || num > MAX_WIN_NUMBERS) {
                throw new IllegalArgumentException(ValidateConstant.ERROR_WIN_NUMBER_RANGE());
            }
        }
        return true;
    }

    public static boolean hasDuplicateNumAndNumbers(Integer targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            throw new IllegalArgumentException(ValidateConstant.ERROR_DUPLICATE_BONUS_WIN_NUBERS());
        }
        return true;
    }
}

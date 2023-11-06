package Validate;

import lotto.utill.Utii;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException {
    private static final String KOREAN_ENGLISH_REGEX = ".*[^0-9\\s].*";
    private static final String KOREAN_ENGLISH_EXCEPTION_COMMA_REGEX = "[^0-9,\\s]";
    private static final String NOTING_STRING = "";
    private static final String BLANK = " ";
    private static final String SPECIAL_CHARACTER_REGEX = "[!@#$%^&*().?\":{}|<>]";
    private static final Character COMMA_CHAR = ',';
    private static final Integer POSITIVE_CONDITION_ZERO = 0;
    private static final Integer ZERO_NUM = 0;
    private static final Integer SIZE_WIN_NUMBERS_HOST = 6;
    private static final Integer MIN_WIN_NUMBERS = 1;
    private static final Integer MAX_WIN_NUMBERS = 45;
    private static final Integer START_BONUS_NUMBER = 1;
    private static final Integer END_BONUS_NUMBER = 45;

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException("[ERROR] 입력에 문자가 포함되어 있습니다.");
        }
    }

    // TODO: 11/6/23 당첨금액 , 제외
    public static void includeStringExceptionComma(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_EXCEPTION_COMMA_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException("[ERROR] 입력에 문자가 포함되어 있습니다.");
        }
    }
//
//    public static void includeSpecialString(String strLine) {
//        Pattern pattern = Pattern.compile(SPECIAL_CHARACTER_REGEX);
//        Matcher matcher = pattern.matcher(strLine);
//
//        if (matcher.matches()) {
//            throw new NumberFormatException("[ERROR] 문자열에 특수 문자가 포함되어 있습니다.");
//        }
//    }
//
//    public static boolean commaStartAndEnd(String strLine) {
//        int length = strLine.length();
//
//        if (strLine.charAt(length - 1) != COMMA_CHAR || strLine.charAt(0) == ',') {
//            return true;
//        }
//
//        throw new NumberFormatException("[ERROR] 처음 또는 끝이 ',' 입니다.");
//    }
//
//    public static void hasConsecutiveEmptyValues(String strLine) {
//        String[] parts = strLine.split(",");
//        boolean hasEmpty = false;
//
//        for (int i = 0; i < parts.length - 1; i++) {
//            if (parts[i].isEmpty() && parts[i + 1].isEmpty()) {
//                throw new NumberFormatException("[ERROR] ',,' 쉼표 사이에 숫자가 없습니다.");
//            }
//        }
//    }

    public static Boolean blankCheck(String strLine) {
        if (!strLine.equals(NOTING_STRING)) {
            return true;
        }
        throw new NumberFormatException("[ERROR] 빈칸은 입력할 수 없습니다.");
    }

    public static void includeBlank(String strLine) {
        if (strLine.contains(BLANK)) {
            throw new NumberFormatException("[ERROR] 입력 중간에 공백이 포함되어 있습니다.");
        }
    }

    public static void negative(String strLine) {
        Integer inputNum = Integer.valueOf(strLine);
        if (inputNum < POSITIVE_CONDITION_ZERO) {
            throw new NumberFormatException("[ERROR] 양수만 입력해 주세요");
        }
    }

    public static void zeroNum(String strLine) {
        Integer inputNum = Integer.valueOf(strLine);

        if (inputNum == ZERO_NUM) {
            throw new NumberFormatException("[ERROR] 0은 입력할수 없습니다.");
        }
    }

    // TODO: 11/6/23 추가.
    public static boolean containsNonNumericCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != '-' && !Character.isWhitespace(c)) {
                throw new NumberFormatException("[ERROR] 숫자를 입력해주세요.");
            }
        }
        return false;
    }

    // 유저
    public static boolean isMultipleOf1000(int amount) {
        if (amount % 1000 == 0) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위 입니다.");
    }

    public static boolean isInRangeBonusNumber(int number) {
        if (number <= START_BONUS_NUMBER || number >= END_BONUS_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45입니다.");
        }
        return false;
    }

    //    // 로또 진행자.
    public static boolean hasDuplicateEachNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer num : numbers) {
            if (!set.add(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 되면 안 됩니다.");
            }
        }

        return false;
    }

    public static boolean isWinNumbersCountSix(List<Integer> numbers) {
        Integer sizeNumbers = numbers.size();
        if (Utii.isSameInt(sizeNumbers, SIZE_WIN_NUMBERS_HOST)) {
            return true;
        }

        throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입니다.");
    }

    public static boolean checkRangeWinNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < MIN_WIN_NUMBERS || num > MAX_WIN_NUMBERS) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호의 범위는 1 ~ 45 입니다.");
            }
        }
        return true;
    }

    public static boolean hasDuplicateNumAndNumbers(Integer targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 중복되는 숫자가 있습니다.");
        }
        return true;
    }
}

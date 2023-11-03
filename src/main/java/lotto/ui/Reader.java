package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    static Pattern numericPattern = Pattern.compile("^[\\d]*$");
    static Pattern mod1000Pattern = Pattern.compile("^[\\d]*+000$");
    public static int getMoney(){
        String inputMoney = Console.readLine();
        validateMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    private static void validateMoney(String inputMoney) {
        validateNumeric(inputMoney);
        validateMod1_000(inputMoney);
    }

    private static void validateNumeric(String inputMoney) {
        if (isNotMatch(numericPattern, inputMoney)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateMod1_000(String inputMoney){
        if (isNotMatch(mod1000Pattern, inputMoney)) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요");
        }
    }

    private static boolean isNotMatch(Pattern pattern, String input){
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}

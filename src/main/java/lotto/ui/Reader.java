package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constance.GameConst;

public class Reader {
    private static Pattern answerPattern = Pattern.compile(
            String.format("^([\\d]+%s){5}+[\\d]$", GameConst.DELIMITER));

    public static int getMoney() {
        String inputMoney = Console.readLine();
        int money = parseInt(inputMoney);
        validateMoneyUnit(money);
        return money;
    }

    public static List<Integer> getAnswerNumbers() {
        String input = Console.readLine();
        validateAnswersFormat(input);
        return Arrays.stream(input.split(GameConst.DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static Integer getBonusNumber() {
        String input = Console.readLine();
        return parseInt(input);
    }

    public static void validateAnswersFormat(String answerNumbers) {
        answerNumbers = answerNumbers.replaceAll(" ", "");
        Matcher matcher = answerPattern.matcher(answerNumbers);
        if(!matcher.matches()){
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다. 여섯 개의 숫자를 ,로 구분해 입력해 주세요");
       }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요");
        }
    }
}

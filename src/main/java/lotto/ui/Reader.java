package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constance.GameConst;
import lotto.util.LottoGameException;

public class Reader {
    private static Pattern answerPattern = Pattern.compile(
            String.format("^([\\d]+%s){5}+[\\d]$", GameConst.DELIMITER));

    public static int getMoney() {
        String inputMoney = Console.readLine();
        int money = parseInt(inputMoney);
        validateMoneyUnit(money);
        validateMoneyRange(money);
        return money;
    }

    public static List<Integer> getAnswerNumbers() {
        String input = Console.readLine();
        validateAnswersFormat(input);
        return Arrays.stream(input.split(GameConst.DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateMoneyRange(int money) {
        if(money > GameConst.LOTTO_PURCHASE_LIMIT){
            throw LottoGameException.OVER_PURCHASE_LIMIT.makeException();
        }
    }

    public static Integer getBonusNumber() {
        String input = Console.readLine();
        return parseInt(input);
    }

    public static void validateAnswersFormat(String answerNumbers) {
        answerNumbers = answerNumbers.replaceAll(" ", "");
        Matcher matcher = answerPattern.matcher(answerNumbers);
        if(!matcher.matches()){
            throw LottoGameException.WRONG_ANSWERS_FORMAT.makeException();
       }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoGameException.WRONG_NUMBER_FORMAT.makeException();
        }
    }

    private static void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw LottoGameException.WRONG_MONEY_UNIT.makeException();
        }
    }
}

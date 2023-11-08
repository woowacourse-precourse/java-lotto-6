package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequestParser {
    private static final String SEPARATOR = ",";

    public static int requestPurchase(){
        String purchase = Console.readLine();
        return integerParser(purchase);
    }

    public static int requestBonus(){
        String bonus = Console.readLine();
        return integerParser(bonus);
    }

    public static List<Integer> requestWinningNumber(){
        String winningNumber = Console.readLine();
        return Arrays.stream(winningNumber.split(SEPARATOR))
                .map(RequestParser::integerParser)
                .collect(Collectors.toList());
    }

    private static int integerParser(String request) {
        try {
            return Integer.parseInt(request);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 값을 입력하셨습니다.", e);
        }
    }
}
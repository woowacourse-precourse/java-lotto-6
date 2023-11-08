package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IO {
    public static void printNoticeln(String ment) {
        System.out.println(ment);
    }
    public static void printNotice(String ment) {
        System.out.print(ment);
    }

    public static String inputBudget() {
        return Console.readLine();
    }
    public static List<Integer> inputWinningNumber()  throws IllegalArgumentException{
        String inputString= Console.readLine();
        return validateWinningNumber(inputString);
    }

    private static List<Integer> validateWinningNumber(String inputString) throws IllegalArgumentException {
        String[] split=validateComma(inputString);
        return validateIsNumberAndRange(split);
    }

    private static List<Integer> validateIsNumberAndRange(String[] split)  throws IllegalArgumentException{
        List<Integer> numberList = new ArrayList<>();
        for (String s : split) {
            Integer number=validateInteger(s);
            validateRange(number);
            numberList.add(number);
        }
        validateDuplicate(numberList);
        return numberList;
    }
    private static void validateDuplicate(List<Integer> numberList) {
        List<Integer> collect = numberList.stream().distinct().collect(Collectors.toList());
        if (collect.size() != numberList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private static void validateRange(Integer number)  throws IllegalArgumentException{
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.");
        }
    }

    private static Integer validateInteger(String s) throws IllegalArgumentException {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static String[] validateComma(String inputString)throws IllegalArgumentException {
        try{
            String[] split = inputString.split(",");
            return split;
        }catch (IllegalArgumentException e) {
           throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 숫자를 입력해주세요.");
        }
    }

    public static Integer BonusNumber( List<Integer> integers) throws IllegalArgumentException{
        String inputString= Console.readLine();
        Integer number=validateBonusNumber(inputString,integers);
        return number;
    }

    private static Integer validateBonusNumber(String inputString, List<Integer> integers) throws IllegalArgumentException{
        Integer number=validateInteger(inputString);
        validateRange(number);
        validateNotContainNumber(inputString, integers);
        return number;
    }

    private static void validateNotContainNumber(String inputString, List<Integer> integers) throws IllegalArgumentException{
        if (integers.contains(Integer.valueOf(inputString))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto.toString());
    }

}

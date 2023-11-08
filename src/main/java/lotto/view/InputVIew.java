package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    private final static String NUMBER_PATTERN = "\\d+";
    public static long getMoney(){
        System.out.println("");
        String input = Console.readLine();
        validateNumber(input);
        return Long.parseLong(input);
    }

    private static void validateNumber(String input) throws IllegalArgumentException{
        if (input != null && input.matches(NUMBER_PATTERN)){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}

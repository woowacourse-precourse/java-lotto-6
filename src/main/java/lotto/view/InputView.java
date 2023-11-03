package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void readBuyAmount() {
        String input = Console.readLine();
        validateSpaceBuyAmount(input);
        validateNotIntegerBuyAmount(input);
    }


    public static void validateSpaceBuyAmount(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다.");
        }
    }

    public static void validateNotIntegerBuyAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }


}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;

public class InputView {

    public Cash InputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = getInput();
        validateNumber(input);
        Integer cash = parseStrToInt(input);
        validateAvailableCash(cash);
        return new Cash(cash);
    }

    private void validateNumber(String input) {
        for (char token : input.toCharArray()) {
            if (!Character.isDigit(token)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력할 수 없습니다. 숫자를 입력해주세요");
            }
        }
    }

    private void validateAvailableCash(Integer input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력가능합니다");
        }
    }

    private Integer parseStrToInt(String number) {
        return Integer.parseInt(number);
    }

    private String getInput() {
        return Console.readLine();
    }
}

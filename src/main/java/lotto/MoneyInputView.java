package lotto;

import camp.nextstep.edu.missionutils.Console;

public class MoneyInputView {

    private String input;
    private int money;

    public MoneyInputView() {
        validate();
    }

    private void validate() {
        input = Console.readLine();
        try {
            nonZero();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validate();
        }
    }


    private void nonZero() {
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException("[ERROR] 0 이 아닌 숫자를 입력해야 합니다.");
        }
        money = Integer.parseInt(input);
    }
}

package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

public class InputMoney {
    private final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력해주세요.";
    private final String UNIT_NOT_THOUSAND = "1000원 단위로 입력하세요.";
    private final OutputView outputView = new OutputView();

    public int Number() {
        String input = Console.readLine();

        try {
            int money = Integer.parseInt(input);
            if (isUnit(money)) {
                return Integer.parseInt(input);
            }
            System.out.println("[ERROR] " + UNIT_NOT_THOUSAND);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + NUMBER_FORMAT_EXCEPTION);
        }
        return 0;
    }

    private boolean isUnit(int money) {
        return money % 1000 == 0;
    }

    public int save() {
        outputView.inputMoney();

        while (true) {
            try {
                int number = Number();
                if (number != 0) {
                    return number;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }
    }
}

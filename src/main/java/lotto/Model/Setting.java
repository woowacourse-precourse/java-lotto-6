package lotto.Model;

import camp.nextstep.edu.missionutils.Console;

public class Setting {

    public int purchase_amount() {
        while (true) {
            String input = Console.readLine();
            if (check_Integer(input) && check_money(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public boolean check_money(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            System.out.println("[ERROR] 입력 금액은 1000의 배수로 입력해주세요.");
            return false;
        }
        return true;
    }

    public boolean check_Integer(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return false;
        }
    }
}


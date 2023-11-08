package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.UserLotto;

public class InputView {
    public static Integer moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String stmoney = Console.readLine();
        return validmoney(stmoney);
    }


//    public static Integer winNumInput() {
//        String
//        return num;
//    }

    private static Integer validmoney(String stmoney) {
        try {

            int money = Integer.parseInt(stmoney);

            if (money < 1000) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
            }

            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
            }
            return money;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    public static UserLotto lottosInput(int money) {
        System.out.printf("\n%d개를 구매했습니다.%n", money);
        UserLotto userLotto = new UserLotto(money);

        return userLotto;
    }
}

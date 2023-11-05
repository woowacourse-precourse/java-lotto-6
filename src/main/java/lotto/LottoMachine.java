package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {

    private int lottoCount;

    public LottoMachine() {
        int money = insertMoney();
        lottoCount = money / 1000;
    }

    private int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = parseInt(Console.readLine());

        try {
            notDividedWithThousand(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return insertMoney();
        }

        return money;
    }

    private void notDividedWithThousand(int money) {
        int remainder = money % 1000;

        if (remainder > 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나눠 떨어지지 않습니다.");
        }
    }


}

package ui;

import camp.nextstep.edu.missionutils.Console;
import dto.LottoMoney;

class InputView {
    private InputView() {
    }

    /**
     * @return 1000 단위로 끊어진 로또 구매 금액.
     */
    public static LottoMoney getMoney() {
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            return new LottoMoney(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액입니다.", e);
        }
    }
}

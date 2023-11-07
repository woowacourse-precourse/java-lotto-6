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
        String input;

        while (true) {
            try {
                input = Console.readLine();
                int money = Integer.parseInt(input);
                return new LottoMoney(money);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            }
        }
    }
}

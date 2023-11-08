package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    int buyMoney=0;
    int buyLottoAmount=0;

    public void insertMoney() {
        int money = 0;
        boolean pass = true;

        System.out.println("구입금액을 입력해 주세요.");
        do {
            money = Integer.parseInt(Console.readLine());
            try {
                checkMoney(money);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                pass = false;
            }
        } while (!pass);
        buyMoney=money;
    }

    private void checkMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000단위로 입력해주세요.");
        }
    }

    public void buyLottoAmount(){
        buyLottoAmount=buyMoney/1000;
    }

    public void showBuyAmount(){
        System.out.println(buyLottoAmount+"개를 구매했습니다.");
    }

}

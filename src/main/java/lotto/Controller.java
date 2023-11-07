package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public int inputMoney() {
        int money;

        String moneyString = Console.readLine();

        money = Integer.parseInt(moneyString);
        
        return money;
    }

    public int computeTryNum(int money) {
        int tryNum;

        moneyValidate(money);

        tryNum = money/1000;
        
        return tryNum;
    }

    public void moneyValidate(int money) {
        //1000으로 나누어떨어지지 않을 때
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }


}

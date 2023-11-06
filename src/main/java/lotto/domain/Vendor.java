package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.ErrorMessageConstant;

public class Vendor {
    private int money;

    public int setMoney() {
        int numOfLotto = 0;
        while (true) {
            try {
                this.money = insertMoney();
                numOfLotto = calculateLottoNum(this.money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numOfLotto;
    }

    public int insertMoney() {
        try {
            String inputMoney = Console.readLine();
            return Integer.parseInt(inputMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessageConstant.NOT_INTEGER);
        }
    }

    public int calculateLottoNum(int money) {
        if(money <= 0){
            throw new IllegalArgumentException(ErrorMessageConstant.CANNOT_INSERT_MINOUS);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.ONLY_DIVIDE_BY_1000);
        }
        return money / 1000;
    }

}

package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Vendor {
    private int money;

    public int setMoney() {
        System.out.println("구입금액을 입력해 주세요.");
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
            String tmp = Console.readLine();
            return Integer.parseInt(tmp);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 양의 점수만 입력하실 수 있습니다.");
        }
    }

    public int calculateLottoNum(int money) {
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력해주세요.");
        }
        return money / 1000;
    }

}

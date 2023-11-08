package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Lottery {
    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private double receivedMoney;

    public void receiveMoney () {
        double receivedMoney = 0;
        try {
            String money = Console.readLine();
            if (money.matches("^-?\\d+$\n")) {
                throw new IllegalArgumentException("정수만 입력 가능합니다.");
            }
            if (Integer.parseInt(money) % 1000 != 0) {
                throw new IllegalArgumentException("입력은 1000 단위로 해주세요.");
            }
        }catch (IllegalArgumentException e){
            System.err.println(EXCEPTION_PREFIX + e.getMessage());
            receiveMoney();
        }finally {
            this.receivedMoney = receivedMoney;
        }
    }


}

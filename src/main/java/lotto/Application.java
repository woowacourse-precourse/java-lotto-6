package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int moneyValue = inputMoney();
    }

    public static int inputMoney() {
        int moneyValue = 0;
        while (true) {
            try {
                String money = UI.inputMoneyValue();

                if (!isValidMoney(money)) throw new IllegalArgumentException();
                moneyValue = Integer.valueOf(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 금액 입력이 아닙니다.");
            }
        }
        return moneyValue;
    }

    public static boolean isValidMoney(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                return false;
            }
        }

        if (Integer.valueOf(money) % 1000 != 0) {
            return false;
        }
        return true;
    }

}

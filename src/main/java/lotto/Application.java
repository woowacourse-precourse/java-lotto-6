package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int moneyValue = inputMoney();
        List<List<Integer>> lottoNum = createLottoNum(moneyValue);
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

    public static List<List<Integer>> createLottoNum(int moneyValue) {
        List<List<Integer>> lottoNum = new ArrayList<>();

        for (int i = 0; i < moneyValue / 1000; i++) {
            List<Integer> innerList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> list = new ArrayList<>(innerList);
            Collections.sort(list);
            lottoNum.add(i, list);
        }
        UI.printLottoNum(lottoNum, moneyValue);
        return lottoNum;
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

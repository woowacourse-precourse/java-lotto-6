package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static List<Integer> winningNumbers = new ArrayList<>();

    public static void main(String[] args) {
        int moneyValue = inputMoney();
        List<List<Integer>> lottoNum = createLottoNum(moneyValue);
        inputWinningNumbers();
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

    public static void inputWinningNumbers() {
        String[] separateWinningNum = new String[6];
        try {
            String winningNum = UI.inputWinningNum();
            separateWinningNum = winningNum.split(",");

            if (!isValidWinningNum(separateWinningNum)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
            separateWinningNumbers(separateWinningNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbers();
        }
    }

    public static void separateWinningNumbers(String[] separateWinningNum) {
        winningNumbers = new ArrayList<>();
        for (int i = 0; i < separateWinningNum.length; i++) {
            winningNumbers.add(Integer.parseInt(separateWinningNum[i]));
        }

        Lotto lotto = new Lotto(winningNumbers);
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

    public static boolean isValidWinningNum(String[] separateWinningNum) {
        for (int i = 0; i < separateWinningNum.length; i++) {
            if (!Character.isDigit(separateWinningNum[i].charAt(0))) {
                return false;
            }
        }
        return true;
    }
}

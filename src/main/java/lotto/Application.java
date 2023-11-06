package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static List<Integer> winningNumbers = new ArrayList<>();

    public static void main(String[] args) {
        int moneyValue = inputMoney();
        List<List<Integer>> lottoNum = createLottoNum(moneyValue);
        inputWinningNumbers();
        int bonusNum = inputBonusNumber();
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

        new Lotto(winningNumbers);
    }

    public static int inputBonusNumber() {
        String bonusNumber = "";
        try {
            bonusNumber = UI.inputBonusNum();

            if (!isValidBonusNumber(bonusNumber)) {
                throw new IllegalArgumentException();
            }
            return Integer.valueOf(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 보너스 번호 입력이 아닙니다.");
            inputBonusNumber();
            return Integer.valueOf(bonusNumber);
        }
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

    public static boolean isValidBonusNumber(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (!Character.isDigit(bonusNumber.charAt(i))) {
                return false;
            }
        }

        if (Integer.valueOf(bonusNumber) < 1 || Integer.valueOf(bonusNumber) > 45) {
            return false;
        }
        if (!isValidSameNumber(bonusNumber)) {
            return false;
        }
        return true;
    }

    public static boolean isValidSameNumber(String bonusNumber) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (Integer.valueOf(bonusNumber).equals(winningNumbers.get(i))) {
                return false;
            }
        }
        return true;
    }
}

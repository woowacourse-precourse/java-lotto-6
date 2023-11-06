package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static List<Integer> winningNumbers = new ArrayList<>();

    public static void main(String[] args) {
        int moneyValue = inputMoney();
        List<List<Integer>> lottoNum = createLottoNum(moneyValue);
        inputWinningNumbers();
        winningStatistics(lottoNum);
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

    public static void winningStatistics(List<List<Integer>> lottoNum) {
        int bonusNum = inputBonusNumber();
        List<Integer> cnt = new ArrayList<>();
        int[] bonusCnt = new int[lottoNum.size()];

        for (int i = 0; i < lottoNum.size(); i++) {
            List<Integer> innerList = new ArrayList<>(lottoNum.get(i));
            innerList.removeAll(winningNumbers);
            lottoNum.set(i, innerList);
            cnt.add(i, 6 - innerList.size());

            if (innerList.contains(bonusNum)) bonusCnt[i] = 1;
        }
        calWinningStatistics(cnt, bonusCnt);
    }

    public static void calWinningStatistics(List<Integer> cnt, int[] bonusCnt) {
        int[] result = new int[5];

        for (int i = 0; i < cnt.size(); i++) {
            if (cnt.get(i) == Award.세개.get일치()) result[0] += Award.세개.get상금();
            else if (cnt.get(i) == Award.네개.get일치()) result[1] += Award.네개.get상금();
            else if (cnt.get(i) == Award.다섯개.get일치() && bonusCnt[i] != 1) result[2] += Award.다섯개.get상금();
            else if (cnt.get(i) == Award.다섯개보너스.get일치() && bonusCnt[i] == 1) result[3] += Award.다섯개보너스.get상금();
            else if (cnt.get(i) == Award.여섯개.get일치()) result[4] += Award.여섯개.get상금();
        }
        double rate = calRate(result, bonusCnt.length);
        UI.printWinningStatistics(result, rate);
    }

    public static double calRate(int[] result, int initialMoney) {
        int money = 0;
        for (int num : result) {
            money += num;
        }
        double rate = (double) money / initialMoney / 1000 * 100;
        rate = Math.round(rate * 100) / 100.0;
        return rate;
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

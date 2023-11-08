package lotto.controller;

import java.util.*;

public class NumberValidator {
    public int buyLottoMoneyValidator(String buyMoney) {
        int money;
        try {
            money = Integer.parseInt(buyMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자가 아닌 문자가 들어왔습니다.");
        }
        return numberOfLotto(money);
    }

    public int numberOfLotto(int money) {
        if (validateMoneyOfLotto(money)) {
            return money / 1000;
        }
        throw new IllegalArgumentException("[ERROR] 돈이 1000원으로 나누어 떨어지지 않습니다.");
    }

    public boolean validateMoneyOfLotto(int money) {
        if (money % 1000 == 0) {
            return true;
        }
        return false;
    }

    public List<Integer> prizeLottoNumValidator(String prizeNums) {
        List<Integer> prizeLottoNums;
        String removeEmptyPrizeNum = prizeNums.replace(" ", "");
        List<String> prizeNumArr = Arrays.asList(removeEmptyPrizeNum.split(","));
        prizeNumValidate(prizeNumStringToInt(prizeNumArr));
        return prizeNumStringToInt(prizeNumArr);
    }

    public void prizeNumValidate(List<Integer> prizeNum) {
        Set<Integer> numSet = new HashSet<>(prizeNum);
        if (prizeNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
        if (numSet.size() != prizeNum.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 중복 된 수가 있습니다.");
        }
    }

    public List<Integer> prizeNumStringToInt(List<String> prizeNumStr) {
        List<Integer> prizeNumInt = new ArrayList<>();
        for (String s : prizeNumStr) {
            try {
                prizeNumInt.add(rangePrizeNum(Integer.parseInt(s)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자가 아닌 문자가 들어왔습니다.");
            }
        }


        return prizeNumInt;
    }

    public int lottoBonusNumValidator(String bonusNum, List<Integer> lo) {
        int num;
        try {
            num = Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 넣어주세요");
        }
        if (lo.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복 됩니다.");
        }

        return rangePrizeNum(num);

    }


    public int rangePrizeNum(int num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자 범위는 1~45입니다.");
        }
        return num;
    }

}

package lotto.domain;

import java.util.*;

public class UserInputChecker {
    public UserInputChecker() {
    }

    public int checkPurchaseAmount(String inputPurchaseAmount) {
        try { // 입력된 구입금액이 숫자인지 확인
            checkInt(inputPurchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        try { // 입력된 구입금액이 1000원 단위인지 확인
            checkInputUnit(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        return purchaseAmount;
    }

    public int checkInputUnit(int purchaseAmount) { //구입금액 단위 확인
        if (purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로만 입력 가능합나다.");
        return purchaseAmount;
    }

    public List<Integer> checkWinningNumbers(String[] input) { // 당첨번호 입력값 확인 메서드
        List<Integer> winningNumbers = new ArrayList<>();
        String[] checkedNumber = checkTypeWinningNumbers(input); // 숫자인지 확인
        if (checkedNumber == null)
            return null;
        for (String number : checkedNumber) {
            winningNumbers.add(Integer.parseInt(number)); // List<Integer>로 변환
        }
        return winningNumbers;
    }

    public String[] checkTypeWinningNumbers(String[] input) { // 입력된 당첨번호가 숫자인지 확인
        for (String checkNumber : input) {
            try {
                checkInt(checkNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return input;
    }

    public int checkBonusNumber(String inputbonusNumber) { // 보너스 번호 확인
        int bonusNumber;
        try { // 숫자인지 확인
            checkInt(inputbonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        bonusNumber = Integer.parseInt(inputbonusNumber);

        return bonusNumber;
    }

    public void checkInt(String input) { // 입력값이 숫자인지 확인
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

}

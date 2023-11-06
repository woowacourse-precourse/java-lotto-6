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
        String[] checkResult = checkTypeWinningNumbers(input); // 숫자인지 확인
        if (checkResult == null)
            return null;
        List<Integer> winningNumbers = new ArrayList<>();
        for (String checkNumber : checkResult) {
            int checkedNumber = checkNumberInRange(Integer.parseInt(checkNumber)); // 숫자 범위 확인
            if (checkedNumber == 0)
                return null;
            winningNumbers.add(checkedNumber);
        }
        if (hasDuplicateWinningNumbers(winningNumbers)) // 중복 숫자 확인
            return null;

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

    public boolean hasDuplicateWinningNumbers(List<Integer> winningNumbers) { // 당첨 번호 중복 확인
        Set<Integer> set = new HashSet<>(winningNumbers);
        try {
            if (set.size() != winningNumbers.size())
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public int checkNumberInRange(int number) { // 입력된 번호가 1~45 사이의 숫자인지 확인
        try {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 1~45사이의 값이 아닙니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        return number;
    }

    public void checkInt(String input) { // 입력값이 숫자인지 확인
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

}

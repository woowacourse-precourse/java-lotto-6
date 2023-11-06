package lotto.util;

import java.util.*;

public class InputVaildate {
    private final static int MONEY_UNIT = 1000;
    public void moneyVaildate(int money) {
        //1000단위인 지 검증
        isUnitMoney(money);
    }
    public void numberVaildate(String inputNumber, String inputBonusNumber) {
        int[] numbers =  convertToIntArr(inputNumber); // util로 분리 예정
        int bonusNumber = convertToInt(inputBonusNumber);
        InvalidNumberOfNumbersException(numbers);
        OutOfRangeException(numbers); // util로 분리 예정
        DuplicateNumbersException(numbers, bonusNumber);
    }

    private int[] convertToIntArr(String inputNumber) {
        String[] strNumbers = inputNumber.split(",");
        return Arrays.stream(strNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private int convertToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }

    public void isUnitMoney(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로만 가능합니다.");
        }
    }

    private void InvalidNumberOfNumbersException(int[] numbers) {
        // 6개가 아닐 때
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 수의 개수가 6개가 아닙니다.");
        }
    }

    private void OutOfRangeException(int[] numbers) {
        // 1 ~ 45 이외의 값
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이에 없는 수가 있습니다.");
            }
        }
    }

    private void DuplicateNumbersException(int[] numbers, int bonusNumber) {
        // 중복된 수
        Set<Integer> setNumbers = new HashSet<>();
        for (int number : numbers) {
            setNumbers.add(number);
        }
        if (setNumbers.size() != numbers.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 있습니다.");
        }
        if (setNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 로또 번호와 중복되었습니다.");
        }
    }

}
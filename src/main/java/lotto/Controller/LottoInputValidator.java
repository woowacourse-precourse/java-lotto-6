package lotto.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInputValidator {

    public void validateBudget(String budgetStr) throws IllegalArgumentException {
        Long budget;

        try {
            budget = Long.parseLong(budgetStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 숫자가아닙니다.");
        }
        if (budget <= 0 || budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 예산은 0보다 크고 1000으로 나누어 떨어져야 합니다.\n");
        }
    }

    public List<Integer> validateNormalNumbersIsInteger(String normalNumbersStr) throws IllegalArgumentException {
        List<Integer> normalNumbers;
        try {
            normalNumbers = Arrays.stream(normalNumbersStr.split(","))
                    .map(String::trim) // 부분 문자열의 앞뒤 공백 제거
                    .map(Integer::parseInt) // 문자열을 정수로 변환
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자여야합니다.");
        }
        return normalNumbers;
    }

    public void validateNormalNumberCount(List<Integer> normalNumbers) {
        if (normalNumbers.size() != 5) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 5개 입력해야합니다.");
        }
    }

    public int validateBonusNumberIsInteger(String bonusNumberStr) throws IllegalArgumentException {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자여야합니다.");
        }
        return bonusNumber;
    }

    public void validateNormalNumbersInRange(List<Integer> normalNumbers) throws IllegalArgumentException {
        List<Integer> errorNumbers = new ArrayList<>();
        for (Integer normalNumber : normalNumbers) {
            if (normalNumber < 1 || normalNumber > 45) {
                errorNumbers.add(normalNumber);
            }
        }
        if (!errorNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 1에서 45 사이의 숫자가 아닙니다 : " + errorNumbers);
        }
    }

    public void validateNormalNumberDuplicated(List<Integer> normalNumbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> errorNumbers = new ArrayList<>();

        for (Integer normalNumber : normalNumbers) {
            if (!uniqueNumbers.add(normalNumber)) {
                errorNumbers.add(normalNumber);
            }
        }
        if (!errorNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 존재합니다: " + errorNumbers);
        }
    }

    public void validateBonusNumberDuplicated(List<Integer> normalNumber, int bonusNumber)
            throws IllegalArgumentException {
        if (normalNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.: " + bonusNumber);
        }
    }
}

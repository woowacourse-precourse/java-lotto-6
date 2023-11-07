package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validate {
    public int getPurchaseMoney(String userInput) throws IllegalArgumentException {
        int purchaseMoney = -1;

        try {
            purchaseMoney = Integer.parseInt(userInput);
            validatePurchaseMoney(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }

        return purchaseMoney;
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0 || purchaseMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상의 1000의 배수만 입력이 가능합니다.");
        }
    }

    public List<Integer> getPrizeNumbers(String userInput) {
        List<Integer> prizeNumbers = new ArrayList<>();

        String input = userInput;
        prizeNumbers = validatePrizeNumbers(input);

        return prizeNumbers;
    }

    private List<Integer> validatePrizeNumbers(String input) {
        List<Integer> prizeNumbers = new ArrayList<>();
        try {
            Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).forEach(i -> {
                rangeValidate(i);
                duplicateValidate(prizeNumbers.contains(i));
                prizeNumbers.add(i);
            });
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자는 공백없는 쉼표로 구분됩니다.");
        }

        sizeValidate(prizeNumbers.size());

        return prizeNumbers;
    }

    private void rangeValidate(int i) {
        if (i > 45 || i < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45까지의 숫자만 허용됩니다.");
        }
    }

    private void duplicateValidate(boolean check) {
        if (check) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 들어갈 수 없습니다.");
        }
    }

    private void sizeValidate(int size) {
        if (size != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개가 입력되어야 합니다.");
        }
    }

    public int getBonusNumber(List<Integer> prizeNumbers, String userInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(userInput);
            validateBonusNumber(bonusNumber, prizeNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }

        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> prizeNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45까지의 숫자만 허용됩니다.");
        }
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}

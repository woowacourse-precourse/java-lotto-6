package lotto.validation;

import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputValidation {
    public int validatePurchaseAmount(String input) {
        validateInputIsNumeric(input);
        validateCheckRangeOfPurchaseAmountInput(input);
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsPositive(purchaseAmount);
        validatePurchaseAmountOutOfRange(purchaseAmount);
        validatePurchaseAmountUnit(purchaseAmount);

        return purchaseAmount;
    }

    public List<Integer> validateWinnerNumbers(String input) {
        validateInputUseCorrectSeperator(input);
        validateWinnerNumbersNumeric(input);
        validateWinnerNumbersPositive(input);
        List<Integer> winnerNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinnerNumbersOutOfRange(winnerNumbers);
        validateDuplicateWinnerNumbers(winnerNumbers);

        return winnerNumbers;
    }

    public int validateBonusNumber(String input) {
        validateInputIsNumeric(input);
        validateCheckRangeOfBonusNumberInput(input);
        int bonusNumber = Integer.parseInt(input);
        validateBonusNumberIsPositive(bonusNumber);
        validateBonusNumberOutOfRange(bonusNumber);

        return bonusNumber;
    }

    public void validateInputIsNumeric(String input) {
        if (!input.matches("[-+]?\\d*")) {
            throw new NumberFormatException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public void validateCheckRangeOfPurchaseAmountInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 21억(2,100,000,000)이하인 양수로 입력해야 합니다.");
        }
    }

    public void validatePurchaseAmountOutOfRange(int purchaseAmount) {
        if (purchaseAmount > 2100000000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 21억(2,100,000,000)이하로 입력해야 합니다.");
        }
    }

    public void validatePurchaseAmountIsPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수로 입력해야 합니다.");
        }
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public void validateInputIsNull(String input) {
        if (input == null || input.equals("")) {
            throw new NullPointerException("[ERROR] 입력값을 확인하세요.");
        }
    }

    public void validateInputUseCorrectSeperator(String input) {
        String deleteAllWords = input.replaceAll("[가-힣a-zA-Z0-9,-]", "");
        if (deleteAllWords.length() != 0) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)를 구분하여 입력하세요.");
        }
    }

    public void validateWinnerNumbersNumeric(String input) {
        String exceptSeperator = input.replaceAll("[,-]", "");
        validateInputIsNumeric(exceptSeperator);
    }

    public void validateCheckRangeOfWinnerNumberInput(String[] input) {
        try {
            for(String number : input) {
                Integer.parseInt(number);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateWinnerNumbersPositive(String input) {
        String[] winnerNumbers = input.split(",");

        validateCheckRangeOfWinnerNumberInput(winnerNumbers);
        for (String number : winnerNumbers) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 양수를 입력해야 합니다.");
            }
        }
    }

    public void validateWinnerNumbersOutOfRange(List<Integer> winnerNumbers) {
        for (Integer number : winnerNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateDuplicateWinnerNumbers(List<Integer> winnerNumbers) {
        Set<Integer> numbers = new HashSet<>();

        for (Integer number : winnerNumbers) {
            numbers.add(number);
        }

        if (winnerNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자는 입력할 수 없습니다.");
        }
    }

    public void validateCheckRangeOfBonusNumberInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateBonusNumberIsPositive(int bonusNumber) {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 양수로 입력해야 합니다.");
        }
    }

    public void validateBonusNumberOutOfRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateDuplicateBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> winnerNumbers = lotto.getLottoNumbers();
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 숫자는 입력할 수 없습니다.");
        }
    }
}

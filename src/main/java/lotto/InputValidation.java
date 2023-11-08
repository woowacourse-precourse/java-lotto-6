package lotto;

public class InputValidation {

    public void validateAmountToPay(String amountToPay) {
        validateInputIsNumbers(amountToPay);
        validateRangeOfPay(amountToPay);
    }
    public void validateWinningNumbers(String[] numbers) {
        validateInputCount(numbers);
        validateInputIsNumbers(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);
    }

    public void validateBonusNumber(String number) {
        validateInputIsNumbers(number);
        validateNumberRange(number);
    }

    public void validateRangeOfPay(String ammoutToPay) {
        int money = Integer.parseInt(ammoutToPay);
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 1000원의 금액을 입력해주세요.");
        }
    }

    private void validateInputCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 형식에 맞춰 입력해주세요.");
        }
    }

    private void validateInputIsNumbers(String[] numbers) {
        for (String inputNumber : numbers) {
            try {
                int number = Integer.parseInt(inputNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    private void validateInputIsNumbers(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void validateNumberRange(String[] numbers) {
        for (String inputNumber : numbers) {
            int number = Integer.parseInt(inputNumber);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요.");
            }
        }
    }

    private void validateNumberRange(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요.");
        }
    }

    private void validateDuplication(String[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].equals(numbers[j])) {
                    throw new IllegalArgumentException("[ERROR] 중복 값을 입력했습니다.");
                }
            }
        }
    }
}

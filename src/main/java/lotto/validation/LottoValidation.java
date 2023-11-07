package lotto.validation;

import java.util.List;

public class LottoValidation {

    public void validatePurchasePrice(String input) {
        validateIsDigit(input);
        validateIsDividedByThousand(input);
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateCharacterLength(numbers);
    }

    private static void validateCharacterLength(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            findNumber(number);
        }
    }

    private void findNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateIsDigit(String price) {
        for (int i = 0; i < price.length(); i++) {
            findDigit(price, i);
        }
    }

    private void findDigit(String price, int i) {
        if (!Character.isDigit(price.charAt(i))) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private void validateIsDividedByThousand(String input) {
        int price = Integer.parseInt(input);
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해 주세요.");
        }
    }
}

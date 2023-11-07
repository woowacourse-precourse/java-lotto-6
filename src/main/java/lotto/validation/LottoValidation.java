package lotto.validation;

import java.util.List;
import java.util.StringTokenizer;

public class LottoValidation {

    private StringTokenizer st;

    public void validatePurchasePrice(String input) {
        validateIsDigit(input);
        validateIsDividedByThousand(input);
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateCharacterLength(numbers);
    }

    public void validateWinningNumbers(String input) {
        String value = input.replace(" ", "");
        validateSeparator(value);
        validateNumberRange(value);
        validateCharacterLength(value);
    }

    public void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateIsDigit(input);
        validateNumberRange(input);

        int value = Integer.parseInt(input);
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == value) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
            }
        }
    }

    private void validateSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 쉼표로 구분하여 입력해 주세요.");
        }

        boolean matches = input.matches("[0-9|,]+");
        if (!matches) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표(,)만 입력 가능합니다.");
        }
    }

    private void validateCharacterLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리여야 합니다.");
        }
    }

    private void validateCharacterLength(String input) {
        st = new StringTokenizer(input, ",");
        int count = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }
        if (count != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            findNumber(number);
        }
    }

    private void validateNumberRange(String input) {
        st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            findNumber(value);
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

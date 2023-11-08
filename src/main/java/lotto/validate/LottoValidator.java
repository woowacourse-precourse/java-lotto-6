package lotto.validate;

import java.util.List;

public class LottoValidator {

    public static int validatePurchaseAmount(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }

        return amount;
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 받습니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와의 중복이 허용되지 않습니다.");
            }
        }
    }
}

package lotto.global.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Validator {
    static void validatePrice(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 가격은 숫자만 가능합니다.");
        }
        int processedPrice = Integer.parseInt(price);
        if (processedPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 1,000원 단위의 숫자만 가능합니다.");
        }
    }

    static void validateNumbers(String numbers) {
        if (numbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백일 수 없습니다.");
        }
        if (!numbers.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 포함해야 합니다.");
        }
        if (numbers.startsWith(",") || numbers.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 쉼표(,) 위치가 적절하지 않습니다.");
        }
        String[] processedNumbers = numbers.split(",");
        if (processedNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
        Arrays.stream(processedNumbers)
                .forEach(number -> {
                    try {
                        int processedNumber = Integer.parseInt(number);
                        if (processedNumber < 1 || processedNumber > 45) {
                            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능합니다.");
                    }
                });
        List<String> seen = new ArrayList<>();
        Arrays.stream(processedNumbers)
                .forEach(number -> {
                    if (seen.contains(number)) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
                    }
                    seen.add(number);
                });
    }

    static void validateBonusNumber(String bonusNumber) {
        try {
            int processedBonusNumber = Integer.parseInt(bonusNumber);
            if (processedBonusNumber < 1 || processedBonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 가능합니다.");
        }
    }
}

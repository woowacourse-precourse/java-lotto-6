package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public void validateInputMoneyIsNumber(String inputMoney) {
        try {
            Long.parseLong(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력이 되어져야 합니다!");
        }
    }

    public void validateNumberUnitIsThousand(Long money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다!");
        }
    }

    public void validateNumberNegativeOrZero(Long money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 아니라 양수여야 합니다!");
        }
    }


    public void validateRightCommaCount(String inputWinnerNumbers,
        List<String> splitedInputWinnerNumbers) {
        long count = inputWinnerNumbers.chars().filter(c -> c == ',').count();
        if (count != splitedInputWinnerNumbers.size() - 1) {
            throw new IllegalArgumentException("[ERROR] 1,2,3,4,5,6 과 같은 형태로 ,로 구분을 해주세요!");
        }
    }


}

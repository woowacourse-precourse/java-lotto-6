package lotto.model;

import static lotto.util.Utils.parseInt;
import static lotto.util.Utils.splitByComma;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class LottoAmount {
    private static final String MONEY_NEGATIVE_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String MONEY_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000 단위로 받습니다.";
    private final Integer lottoAmount;

    public LottoAmount(String inputMoney) {
        Integer number = validateMoneyIsValid(inputMoney);
        this.lottoAmount = number;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public static int validateMoneyIsValid(String input) {
        int number = parseInt(input);
        validateMoneyIsPositive(number);
        validateMoneyDivideBy1000(number);
        return number / 1000;
    }

    private static void validateMoneyIsPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR_MESSAGE);
        }
    }

    private static void validateMoneyDivideBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_FORMAT_ERROR_MESSAGE);
        }
    }

}


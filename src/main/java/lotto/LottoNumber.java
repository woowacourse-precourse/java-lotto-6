package lotto;

import static lotto.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.LottoConstants.LOTTO_MIN_NUMBER;

import exception.LottoException;
import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    public static List<Integer> validateLottoNumbers(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = validateLottoNumber(number);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    public static int validateLottoNumber(String number) {
        int num = LottoPurchaseAmount.validateInt(number);
        if (num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LottoException.NOT_LOTTO_NUMBER_FROM_MIN_TO_MAX);
        }
        return num;
    }
}

package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class InputCheck {

    public int checkPaymentAmount(String input) {
        int paymentAmount = LottoException.checkInvalidNumber(input);
        LottoException.checkUnitPaymentAmount(paymentAmount);
        LottoException.checkRangePaymentAmount(paymentAmount);
        return paymentAmount;
    }

    public Lotto checkWinningNumber(String input) {
        List<String> inputNumbers = Arrays.asList(input.split(","));
        LottoException.checkLastComma(input);
        for (String number : inputNumbers) {
            LottoException.checkInvalidNumber(number);
        }
        return new Lotto(parseNumber(inputNumbers));
    }

    public static List<Integer> parseNumber(List<String> numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    public int checkBonusNumber(String input, Lotto winningNumber) {
        int bonusNumber = LottoException.checkInvalidNumber(input);
        LottoException.checkRangeLottoNumber(bonusNumber);
        LottoException.checkDuplicationBonusNumber(winningNumber.getNumbers(), bonusNumber);
        return bonusNumber;
    }
}
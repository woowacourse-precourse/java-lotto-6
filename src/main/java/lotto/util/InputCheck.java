package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.model.User;

public class InputCheck {
    User user = new User();

    public void checkPaymentAmount(String input) {
        user.setPaymentAmount(Exception.checkInvalidNumber(input));
        Exception.checkUnitPaymentAmount(user.getPaymentAmount());
        Exception.checkRangePaymentAmount(user.getPaymentAmount());
    }

    public void checkWinningNumber(String input) {
        List<String> inputNumbers = Arrays.asList(input.split(","));
        Exception.checkLastComma(input);
        for (String number : inputNumbers) {
            Exception.checkInvalidNumber(number);
        }
        user.setWinningNumber(new Lotto(parseNumber(inputNumbers)));
    }

    public static List<Integer> parseNumber(List<String> numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    public void checkBonusNumber(String input) {
        user.setBonusNumber(Exception.checkInvalidNumber(input));
        Exception.checkRangeLottoNumber(user.getBonusNumber());
        Exception.checkDuplicationBonusNumber(user.getWinningNumber().getNumbers(), user.getBonusNumber());
    }
}
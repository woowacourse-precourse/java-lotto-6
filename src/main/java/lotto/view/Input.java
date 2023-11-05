package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class Input {
    public static int inputPayment() {
        String payment = Console.readLine();
        return numberToInteger(payment);
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return numberToInteger(bonusNumber);
    }

    public static int numberToInteger(String payment) {
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputLotto() {
        String lotto = Console.readLine();
        List<String> splitLotto = splitNumbersByComma(lotto);
        return lottoToInteger(splitLotto);
    }

    public static List<String> splitNumbersByComma(String numbersForSplit) {
        return List.of(numbersForSplit.split(","));
    }

    public static List<Integer> lottoToInteger(List<String> splitLotto) {
        List<Integer> integerWinningNumbers = new ArrayList<>();

        for (String number : splitLotto) {
            try {
                integerWinningNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return integerWinningNumbers;
    }


}

package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.ExceptionView;
import lotto.view.InputView;

public class Input {
    private static Lotto answerLotto;

    public static Money inputMoney() {
        while (true) {
            try {
                InputView.inputMoneyMessage();
                Money money = new Money(userInput());
                return money;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                ExceptionView.inputAmountErrorMessage();
            }
        }
    }

    public static Lotto inputAnswerLotto() {
        while (true) {
            try {
                InputView.inputAnswerMessage();
                answerLotto = new Lotto(stringToListOfInteger(userInput()));
                return answerLotto;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                ExceptionView.inputLottoNumberErrorMessage();
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                InputView.inputBonusNumberMessage();
                return validate(userInput());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                ExceptionView.inputBonusNumberErrorMessage();
            }
        }
    }

    private static List<Integer> stringToListOfInteger(String input) {
        List<String> inputListOfString = stringToListOfString(input);
        return listDataTypeConversion(inputListOfString);
    }

    private static List<Integer> listDataTypeConversion(List<String> input) {
        List<Integer> answerLottoNumber = new ArrayList<>();
        for (String s : input) {
            answerLottoNumber.add(Integer.parseInt(s));
        }
        return answerLottoNumber;
    }

    private static List<String> stringToListOfString(String input) {
        return List.of(input.split(","));
    }

    private static int validate(String input) {
        int inputNumber = validateBonusNumberRange(input);
        validateAnswerContainBonusNumber(inputNumber);
        return inputNumber;
    }

    private static int validateBonusNumberRange(String input) {
        if (!(Constant.LOTTO_START_RANGE <= Integer.parseInt(input)
                && Integer.parseInt(input) <= Constant.LOTTO_END_RANGE)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private static void validateAnswerContainBonusNumber(int inputNumber) {
        if (answerLotto.isContain(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static String userInput() {
        return Console.readLine();
    }
}

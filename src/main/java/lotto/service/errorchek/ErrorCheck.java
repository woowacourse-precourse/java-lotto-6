package lotto.service.errorchek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.fixeddata.ErrorText;
import lotto.fixeddata.NumberData;
import lotto.fixeddata.Text;
import lotto.vo.winning.LottoWinning;

public class ErrorCheck {
    private static long IsNumber64bit(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(
                    ErrorText.ERROR + ErrorText.BUY_MONEY_NUMBER_ERROR + ErrorText.NOT_NUMBER);
        }
    }

    private static void MoneyRange(long input) {
        if (input >= NumberData.MONEY_RANGE_MIN && input <= NumberData.MONEY_RANGE_MAX) {
            UnitConfirmation(input);
            return;
        }
        throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.BUY_MONEY_RANGE_ERROR);
    }


    private static void UnitConfirmation(long input) {
        if (input % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(
                ErrorText.ERROR + ErrorText.BUY_MONEY_NUMBER_ERROR + ErrorText.INCORRECTLY_NUMBER);
    }

    public static long MoneyInput(String input) {
        long money = IsNumber64bit(input);
        MoneyRange(money);
        return money;
    }

    private static int IsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_NUMBER_ERROR + ErrorText.NOT_NUMBER);
        }
    }

    private static int WiningNumberRange(int input) {
        if (input >= NumberData.MIN_LOTTO_NUMBER && input <= NumberData.MAX_LOTTO_NUMBER) {
            return input;
        }
        throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_RANGE_ERROR);
    }

    private static Lotto IsNumberMulti(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberText : input) {
            numbers.add(WiningNumberRange(IsNumber(numberText)));
        }
        return new Lotto(numbers);
    }

    private static void WinningLottoDuplicateNumber(List<String> input) {
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }

    private static Lotto SeparatorWinnerNumber(String input) {
        List<String> NumbersText = new ArrayList<>(Arrays.asList(input.split(Text.LOTTO_NUMBER_SEPARATOR)));
        WinningLottoDuplicateNumber(NumbersText);
        return IsNumberMulti(NumbersText);
    }

    public static Lotto WinnerNumberInput(String input) {
        return SeparatorWinnerNumber(input);
    }

    private static int BonusNumberRange(int input) {
        if (input >= NumberData.MIN_LOTTO_NUMBER && input <= NumberData.MAX_LOTTO_NUMBER) {
            return input;
        }
        throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_BONUS_RANGE_ERROR);
    }

    private static void BonusDuplicateNumber(int firstNumber, int secondNumber) {
        if (firstNumber == secondNumber) {
            throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }

    private static int CheckDuplicateNumber(String input) {
        int bonusnumber = BonusNumberRange(IsNumber(input));
        for (int number : LottoWinning.GetWinningNumber().GetLotto()) {
            BonusDuplicateNumber(number, bonusnumber);
        }
        return bonusnumber;
    }

    public static int BonusNumberInput(String input) {
        return CheckDuplicateNumber(input);
    }

    public static void WinningValueOf() {
        throw new NullPointerException(ErrorText.ERROR);
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.CommonLotto;
import lotto.ErrorMessage;

public class LottoInput {
    public static int inputLottoPrice() {
        String input = Console.readLine();
        validateLottoNumber(input);
        validateLottoPrice(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningNum() {
        String input = Console.readLine();
        validateinputWinnigNum(input);
        return inputToLottoNums(input);
    }

    public static int inputBonusNum() {
        String input = Console.readLine();
        validateWinningNumRange(input);
        return Integer.parseInt(input);
    }

    public static void validateLottoNumber(String input) {
        if (!input.matches("\\d+")) {
            ErrorMessage.numberExcept();
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoPrice(String input) {
        int inputNum = Integer.parseInt(input);
        if (inputNum % CommonLotto.LOTTO_PRICE != 0) {
            ErrorMessage.priceExcept();
            throw new IllegalArgumentException();
        }
    }

    public static void validateinputWinnigNum(String input) {
        validateWinningNumCount(input);
        validateWinningNumRange(input);
        validateWinningtNumRedundant(input);
    }


    public static void validateWinningNumCount(String input) {
        int length = input.split(CommonLotto.SEPERATOR, -1).length;
        if (length != CommonLotto.LOTTO_COUNT) {
            ErrorMessage.numCountExcept();
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumRange(String input) {
        List<Integer> WinningNum = inputToLottoNums(input);
        WinningNum.stream().forEach(num -> {
            if (num < CommonLotto.LOTTO_MIN || num > CommonLotto.MAX_NUMBER) {
                ErrorMessage.numRangeExcept();
                throw new IllegalArgumentException();
            }
        });
    }

    public static void validateWinningtNumRedundant(String input) {
        List<String> winningVal = Arrays.asList(input.split(CommonLotto.SEPERATOR));
        boolean isRedundant = winningVal.size() > new HashSet<>(winningVal).size();
        if (isRedundant) {
            ErrorMessage.redundantExcept();
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputToLottoNums(String input) {
        return Arrays.stream(input.split(CommonLotto.SEPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}

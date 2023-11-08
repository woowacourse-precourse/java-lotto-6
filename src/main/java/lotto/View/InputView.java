package lotto.View;

import static lotto.Global.Constants.splitSymbol;
import static lotto.Global.Exception.LOTTO_OUT_OF_RANGE_INPUT;
import static lotto.Global.Exception.NOT_NUMBER_VALUE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern isNumber = Pattern.compile("\\d+");


    public List<Integer> numberListSplitInput(int length) {
        String input = Console.readLine();
        if (!checkSplitBySymbol(input, length)) {
            throw new IllegalArgumentException(
                    LOTTO_OUT_OF_RANGE_INPUT.getErrorPhrase(splitSymbol));
        }
        return convertStringListToIntegerList(Arrays.stream(input.split(splitSymbol)).toList());
    }

    public int singleNumberInput() {
        String input = Console.readLine();
        if (!checkIfNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_VALUE.getErrorPhrase());
        }
        return Integer.parseInt(input);
    }

    private Boolean checkIfNumber(String input) {
        return isNumber.matcher(input).matches();
    }

    private Boolean checkSplitBySymbol(String input, int length) {
        return input.split(splitSymbol).length == length;
    }

    private List<Integer> convertStringListToIntegerList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String number : input) {
            if (!checkIfNumber(number)) {
                throw new IllegalArgumentException(NOT_NUMBER_VALUE.getErrorPhrase());
            }
            result.add(Integer.parseInt(number));
        }
        return result;
    }

}

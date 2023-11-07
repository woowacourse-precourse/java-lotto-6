package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Global.Exception;

public class InputView {
    private static final Pattern isNumber = Pattern.compile("\\d+");
    private static final String splitSymbol = ",";

    public List<Integer> NumberListSplitInput(int length) {
        String input = Console.readLine();
        if (!checkSplitBySymbol(input, length)) {
            throw new IllegalArgumentException(
                    Exception.LOTTO_WINNING_NUMBER_INPUT.getErrorPhrase(splitSymbol));
        }
        return convertStringListToIntegerList(Arrays.stream(input.split(splitSymbol)).toList());
    }

    public int SingleNumberInput() {
        String input = Console.readLine();
        if (!checkIfNumber(input)) {
            throw new IllegalArgumentException(Exception.NOT_NUMBER_VALUE.getErrorPhrase());
        }
        return Integer.parseInt(input);
    }

    private Boolean checkIfNumber(String input) {
        return isNumber.matcher(input).matches();
    }

    private Boolean checkSplitBySymbol(String input, int length) {
        return input.split(splitSymbol).length == length;
        //해당 심볼 외의 심볼을 입력하는 경우 -> 걸러짐(split했을때 length=1)
        //하나만 입력하는 경우 -> 걸러짐(split했을때 length=1)
    }

    private List<Integer> convertStringListToIntegerList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String number : input) {
            if (!checkIfNumber(number)) {
                throw new IllegalArgumentException(Exception.NOT_NUMBER_VALUE.getErrorPhrase());
            }
            result.add(Integer.parseInt(number));
        }
        return result;
    }

}

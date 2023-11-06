package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern isNumber = Pattern.compile("\\d+");

    public List<Integer> NumberListInput(String splitSymbol) {
        String input = Console.readLine();
        if (!checkSplitBySymbol(input, splitSymbol)) {
            //에러 출력
        }
        return convertStringListToIntegerList(Arrays.stream(input.split(splitSymbol)).toList());
    }

    public int SingleNumberInput() {
        String input = Console.readLine();
        if (!checkIfNumber(input)) {
            //에러 출력
        }
        return Integer.parseInt(input);
    }

    private Boolean checkIfNumber(String input) {
        return isNumber.matcher(input).matches();
    }

    private Boolean checkSplitBySymbol(String input, String symbol) {
        return input.split(symbol).length > 1;
        //해당 심볼 외의 심볼을 입력하는 경우 -> 걸러짐(split했을때 length=1)
        //하나만 입력하는 경우 -> 걸러짐(split했을때 length=1)
    }

    private List<Integer> convertStringListToIntegerList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String number : input) {
            if (!checkIfNumber(number)) {
                //에러메시지 출력
            }
            result.add(Integer.parseInt(number));
        }
        return result;
    }

}

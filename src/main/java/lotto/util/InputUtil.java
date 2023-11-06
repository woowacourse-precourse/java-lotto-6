package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    public String getInput() {
        return Console.readLine();
    }
    public int inputStrToInt(String input){
        return Integer.parseInt(input);
    }
    public List<Integer> strToIntegerList(String[] input){
        List<Integer> inputNumbers = new ArrayList<>();
        for (String tmp : input) {
            int typeCast = Integer.parseInt(tmp.trim());
            inputNumbers.add(typeCast);
        }
        return inputNumbers;
    }
}

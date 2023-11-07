package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputWinningNum {

    public static List<Integer> input(String input, String bonus) {
        List<String> inputNums = Arrays.asList(input.split(","));

        List<Integer> winningNums = new ArrayList<>();

        for(String num : inputNums) {
            winningNums.add(Integer.parseInt(num));
        }

        winningNums.add(Integer.parseInt(bonus));

        return winningNums;
    }
}

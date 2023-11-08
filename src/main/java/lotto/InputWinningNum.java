package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputWinningNum {
    private static final String error = "[ERROR]";

    public static List<Integer> input(String input, String bonus) {
        List<String> inputNums = Arrays.asList(input.split(","));
        List<Integer> winningNums = new ArrayList<>();

        for(String num : inputNums) {
            winningNums.add(Integer.parseInt(num));
        }

        for(Integer num : winningNums) {
            if (num < 0 || num > 45) {
                throw new IllegalArgumentException(error + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        winningNums.add(Integer.parseInt(bonus));
        return winningNums;
    }
}

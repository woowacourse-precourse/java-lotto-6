package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Input {
    public int getPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        String inputNumbers = Console.readLine();

        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int getBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}

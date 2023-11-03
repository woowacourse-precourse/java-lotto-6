package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InputView {
    private InputView() {}

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        
        // validation 추가 예정

        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumberList() {
        String input = Console.readLine();

        // validation 추가 예정
        
        
        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::parseInt)
                .collect(toList());
    }

    public static int readBonusNumber() {
        String input = Console.readLine();

        // validation 추가 예정

        return Integer.parseInt(input);
    }
}

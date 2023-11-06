package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String PRESS_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public static List<Integer> getWinningNumber() {
        System.out.println(PRESS_WINNING_NUMBER);
        String result = Console.readLine();
        System.out.println();
        return Stream.of(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

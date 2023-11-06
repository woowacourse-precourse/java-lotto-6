package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private static final Validation validation = new Validation();

    public List<Integer> getWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        try {
            winningNumber = Arrays.stream(Console.readLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .peek(number -> {
                        validation.numberRange(number);
                    })
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        return winningNumber;
    }

    public int getInputNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        return number;
    }
}
